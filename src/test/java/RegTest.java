import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pageObject.RegPage;
import user.AuthUserRequest;
import user.CreateUserRequest;
import api.ApiUserData;

import static user.CreateUserRequest.getUserCreds;
import static user.CreateUserRequest.getUserWrongPassword;

public class RegTest extends MainTest {

    CreateUserRequest createUserRequest = new CreateUserRequest();
    CreateUserRequest createTheUserWrongPassword = new CreateUserRequest();
    ApiUserData regAndAuthUser = new ApiUserData();

    @Test
    @DisplayName("success registration on the site")
    public void verifySuccessRegIsPossible() {
        RegPage regPage = new RegPage(webDriver);
        createUserRequest = getUserCreds();
        regPage.openRegPage();
        regPage.regDataField(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword());
        regPage.clickRegAccountButton();
        regPage.checkLoginButtonIsDisplayed();
    }

    @Test
    @DisplayName("entering a short password")
    public void verifyErrorShortPasswordReg() {
        RegPage regPage = new RegPage(webDriver);
        createTheUserWrongPassword = getUserWrongPassword();
        regAndAuthUser.regNewUser(createTheUserWrongPassword);
        regPage.openRegPage();
        regPage.regDataField(createTheUserWrongPassword.getName(), createTheUserWrongPassword.getEmail(), createTheUserWrongPassword.getPassword());
        regPage.clickRegAccountButton();
        Assert.assertEquals("Некорректный пароль", regPage.getTextPasswordError());
    }

    @After
    public void removeUser() {
        ApiUserData regAndAuthUser = new ApiUserData();
        AuthUserRequest authUserRequest = new AuthUserRequest();
        Response response = regAndAuthUser.authUser(authUserRequest);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            regAndAuthUser.removeUser(accessToken);
        }
    }
}