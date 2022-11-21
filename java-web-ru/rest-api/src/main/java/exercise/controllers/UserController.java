package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;

import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();
        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    }

    ;

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id.equalTo(Long.parseLong(id))
                .findOne();
        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    }

    ;

    public void create(Context ctx) {

        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        ctx.bodyValidator(User.class)
                .check(usr -> !usr.getFirstName().isEmpty(), "Имя не должно быть пустым")
                .check(usr -> !usr.getLastName().isEmpty(), "Фамилия не должна быть пустой")
                .check(usr -> EmailValidator.getInstance().isValid(usr.getEmail()), "Email введен неверно")
                .check(usr -> StringUtils.isNumeric(usr.getPassword()), "Пароль должен содержать только цифры")
                .check(usr -> usr.getPassword().length() > 4, "Пароль должен содержать не менее 4 символов")
                .get();
        user.save();
        // END
    }

    ;

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.update();
        // END
    }

    ;

    public void delete(Context ctx, String id) {
        // BEGIN
        new QUser()
                .id.equalTo(Long.parseLong(id))
                .delete();
        // END
    }

    ;
}
