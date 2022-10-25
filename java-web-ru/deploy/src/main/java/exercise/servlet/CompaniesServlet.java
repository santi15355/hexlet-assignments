package exercise.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        // BEGIN
        List<String> result = new ArrayList<>();
        String param = request.getQueryString();
        String paramValue = request.getParameter("search");
        PrintWriter out = response.getWriter();

        if (param == null || paramValue == null) {
            result = getCompanies();
        } else {
            List<String> companies = getCompanies().stream()
                    .filter(cmp -> cmp.contains(paramValue))
                    .collect(Collectors.toList());
            if (companies.size() == 0) {
                out.println("Companies not found");
            } else {
                result = companies;
            }
        }
        for (var company : result) {
            out.println(company);
        }
    }
    // END
}

