package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import user.AuthUserRequest;
import user.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class ApiUserData {
    String baseUri = "http://stellarburgers.nomoreparties.site/api/";

    @Step("user registration")
    public Response regNewUser(CreateUserRequest createUserRequest) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(createUserRequest)
                .post("auth/register");
        response.then();
        return response;
    }

    @Step("user authorization")
    public Response authUser(AuthUserRequest authUserRequest) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(authUserRequest)
                .post("auth/login");
        response.then();
        return response;
    }

    @Step("Получение access token успешно зарегистрированного пользователя")
    public String getAccessToken(AuthUserRequest authUserRequest) {
        return authUser(authUserRequest)
                .then()
                .extract()
                .path("accessToken");
    }

    @Step("user delete request")
    public Response removeUser(String accessToken) {
        Response response = given()
                .header("Authorization", accessToken)
                .baseUri(baseUri)
                .when()
                .delete("auth/user");
        return response;
    }
}