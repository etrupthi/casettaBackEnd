
package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dao.UserDao;
import models.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

import java.util.Optional;

public class UsersController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(UsersController.class);

    private UserDao userDao;

    @Inject
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Result registerUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        if (null == user.getUsername() ||
                null == user.getPassword() ||
                null == user.getEmail()) {
            return badRequest("Missing mandatory parameters");
        }

        final Optional<User> existingUser = userDao.read(user.getUsername());

        if (existingUser.isPresent()) {
            return badRequest("User taken");
        }

        user.setState(User.State.VERIFIED);
        user.setRole(User.Role.USER);

        userDao.create(user);

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }

    @Transactional
    public Result signInUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        if (null == user.getUsername() ||
                null == user.getPassword()) {
            return badRequest("Missing mandatory parameters");
        }

        final Optional<User> existingUser = userDao.read(user.getUsername());

        if (!existingUser.isPresent()) {
            return unauthorized("Wrong username");
        }

        final User u = existingUser.get();


        if (!u.getPassword().equals(user.getPassword())) {
            return unauthorized("Wrong password");
        }

        if (existingUser.get().getState() != User.State.VERIFIED) {
            return unauthorized("Account not verified");
        }

        existingUser.get().setAccessToken(generateAccessToken());

        userDao.update(existingUser.get());

        final JsonNode result = Json.toJson(existingUser);

        return ok(result);
    }


    @Transactional
    private String generateAccessToken() {
        return "ABC1234";
    }


    @Transactional
    public Result signOutUser() {

        // TODO

        return status(NOT_IMPLEMENTED);
    }

    @Transactional
    public Result getCurrentUser() {

        final Optional<String> authHeader = request().header("Authorization");
        if (!authHeader.isPresent()) {
            return unauthorized("Go and sign in");
        }

        LOGGER.debug("Auth token = {}", authHeader.get());

        if (!authHeader.get().startsWith("Bearer ")) {
            return unauthorized("Invalid auth header format");
        }

        final String accessToken = authHeader.get().substring(7);
        LOGGER.debug("accessToken {}", accessToken);
        if (accessToken.isEmpty()) {
            return unauthorized("Invalid auth header format");
        }

        final User user = userDao.findUserByAuthToken(accessToken);
        if (null== user) {
            return unauthorized("User not found");
        }


        final JsonNode result = Json.toJson(user);

        return ok(result);
    }


}