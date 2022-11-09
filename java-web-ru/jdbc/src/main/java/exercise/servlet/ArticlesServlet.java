package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public final class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        String textPage = request.getParameter("page");
        int page;
        final int articlesPerPage = 10;
        int numberOfArticles;
        try {
            String query0 = "SELECT COUNT(*) FROM articles;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query0);
            result.next();
            numberOfArticles = result.getInt("count(*)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (textPage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(textPage);
        }
        if (page <= 0 || page > numberOfArticles / articlesPerPage + 1) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        List<Map<String, String>> articles = new ArrayList<>();
        String query = "SELECT * FROM articles ORDER BY id LIMIT ? OFFSET ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, articlesPerPage);
            statement.setInt(2, articlesPerPage * (page - 1));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                articles.add(Map.of(

                        "id", result.getString("id"),
                        "title", result.getString("title"),
                        "body", result.getString("body"))
                );
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("articles", articles);
        request.setAttribute("page", page);
        // END
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                             HttpServletResponse response)
            throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        String id = getId(request);
        Map<String, String> article = new HashMap<>();
        String queryMaxId = "SELECT MAX(id) FROM articles";
        int maxId;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryMaxId);
            result.next();
            maxId = result.getInt("max(id)");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        assert id != null;
        if (Integer.parseInt(id) > maxId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        String query = "SELECT title, body FROM articles WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                article.put("title", rs.getString("title"));
                article.put("body", rs.getString("body"));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("article", article);

        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
