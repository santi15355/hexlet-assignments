package exercise.controllers;

import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

import io.javalin.core.validation.Validator;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
                .id.equalTo(id)
                .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        Validator<String> firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                .check(fn -> !fn.isEmpty(), "Поле имя не должно быть пустым");
        Validator<String> lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                .check(ln -> !ln.isEmpty(), "Поле фамилия не должно быть пустым");
        Validator<String> emailValidator = ctx.formParamAsClass("email", String.class)
                .check(email -> EmailValidator.getInstance().isValid(email), "Поле email не корректно");
        Validator<String> passwordValidator = ctx.formParamAsClass("password", String.class)
                .check(pass -> StringUtils.isNumeric(pass), "Пароль должен содержать только цифры")
                .check(pass -> pass.length() > 4, "Длина пароля не менее 4 цифр");

        Map<String, List<ValidationError<?>>> errors = JavalinValidation.collectErrors(
                firstNameValidator, lastNameValidator, emailValidator, passwordValidator);

        User user = new User(
                ctx.formParam("firstName"),
                ctx.formParam("lastName"),
                ctx.formParam("email"),
                ctx.formParam("password")
        );

        if (!errors.isEmpty()) {
            ctx.status(422);
            ctx.attribute("errors", errors);
            ctx.attribute("user", user);
            ctx.render("users/new.html");
            return;
        }
        user.save();
        ctx.sessionAttribute("flash", "Пользователь успешно добавлен");
        ctx.redirect("/users");
        // END
    };
}
