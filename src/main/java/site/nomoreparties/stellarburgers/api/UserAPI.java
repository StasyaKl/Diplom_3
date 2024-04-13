package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI {
    public static String POST_REGISTER_USER = "api/auth/register";
    public static String POST_LOGIN_USER = "api/auth/login";
    public static String DELETE_USER = "api/auth/user";
    @Step("Отправка POST-запроса. Регистрация пользователя")
    public static void postUserCreateRequest(UserPogo userPogo) {
        given()
                .contentType(ContentType.JSON)
                .and()
                .body(userPogo)
                .post(POST_REGISTER_USER);
    }
    @Step("Отправка POST-запроса. Авторизация пользователя")
    public static Response postUserLoginRequest(UserPogo userPogo) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body(userPogo)
                .post(POST_LOGIN_USER);
    }

    @Step("Отправка DELETE-запроса. Удаление пользователя")
    public static void deleteUserRequest(String accessToken) {
        given()
                .auth().oauth2(accessToken)
                .delete(DELETE_USER);
    }
}