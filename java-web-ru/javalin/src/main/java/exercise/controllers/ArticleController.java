package exercise.controllers;

import io.javalin.http.Handler;
import io.ebean.PagedList;

import java.util.List;
import java.util.Objects;

import exercise.domain.query.QArticle;
import exercise.domain.Article;
import exercise.domain.Category;
import exercise.domain.query.QCategory;

public final class ArticleController {

    public static Handler listArticles = ctx -> {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int rowsPerPage = 10;
        int offset = (page - 1) * rowsPerPage;

        PagedList<Article> pagedArticles = new QArticle()
                .setFirstRow(offset)
                .setMaxRows(rowsPerPage)
                .orderBy()
                .id.asc()
                .findPagedList();

        List<Article> articles = pagedArticles.getList();

        ctx.attribute("articles", articles);
        ctx.attribute("page", page);
        ctx.render("articles/index.html");
    };

    public static Handler newArticle = ctx -> {
        List<Category> categories = new QCategory().findList();
        ctx.attribute("categories", categories);
        ctx.render("articles/new.html");
    };

    public static Handler createArticle = ctx -> {
        String title = ctx.formParam("title");
        String body = ctx.formParam("body");
        long categoryId = ctx.formParamAsClass("categoryId", Long.class).getOrDefault(null);

        Category category = new QCategory()
                .id.equalTo(categoryId)
                .findOne();
        Article article = new Article(title, body, category);
        article.save();

        ctx.sessionAttribute("flash", "Статья успешно создана");
        ctx.redirect("/articles");
    };

    public static Handler showArticle = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();

        ctx.attribute("article", article);
        ctx.render("articles/show.html");
    };

    public static Handler editArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();
        List<Category> categories = new QCategory()
                .findList();
        ctx.attribute("article", article);
        ctx.attribute("categories", categories);
        ctx.render("articles/edit.html");
        // END
    };

    public static Handler updateArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        String body = ctx.formParam("body");
        String title = ctx.formParam("title");
        long categoryId = ctx.formParamAsClass("categoryId", Long.class).getOrDefault(null);
        new QArticle()
                .id.equalTo(id)
                .asUpdate()
                .set("title", title)
                .set("body", body)
                .set("category", categoryId)
                .update();
        ctx.sessionAttribute("flash", "Статья успешно обновлена");
        ctx.redirect("/articles");
        // END
    };

    public static Handler deleteArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();
        List<Category> categories = new QCategory()
                .findList();
        ctx.attribute("article", article);
        ctx.attribute("categories", categories);
        ctx.sessionAttribute("article", article);
        ctx.render("articles/delete.html");
        // END
    };

    public static Handler destroyArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        Objects.requireNonNull(new QArticle()
                        .id.equalTo(id)
                        .findOne())
                .delete();
        ctx.sessionAttribute("flash", "Статья успешно удалена");
        ctx.redirect("/articles");
        // END
    };
}
