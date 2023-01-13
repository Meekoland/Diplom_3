import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.AuthPage;
import pageObject.BuilderPage;
import pageObject.PersonalDataPage;
import pageObject.RegPage;
import user.AuthUserRequest;
import user.CreateUserRequest;
import api.ApiUserData;

import static user.CreateUserRequest.getUserCreds;

public class AuthTest extends MainTest {

    CreateUserRequest createUserRequest = new CreateUserRequest();
    ApiUserData regAndAuthUser = new ApiUserData();
    RegPage regPage;
    PersonalDataPage personalDataPage;
    BuilderPage builderPage;
    AuthPage authPage;

    @Before
    public void setUp() {
        regPage = new RegPage(webDriver);
        personalDataPage = new PersonalDataPage(webDriver);
        builderPage = new BuilderPage(webDriver);
        authPage = new AuthPage(webDriver);
        createUserRequest = getUserCreds();
        regAndAuthUser.regNewUser(createUserRequest);
    }

    @Test
    @DisplayName("sign in with the Sign In button on Main page")
    public void testLoginToAccountWithButtonOnMainPage() {
        authPage.clickLoginAccountBottom();
        authPage.setEmailField(createUserRequest.getEmail());
        authPage.setPasswordField(createUserRequest.getPassword());
        authPage.clickLoginBottom();
        builderPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("login by button Personal account")
    public void testLoginToPersonalAccountButtonOnMainPage() {
        authPage.clickPersonalAccountBottom();
        authPage.setEmailField(createUserRequest.getEmail());
        authPage.setPasswordField(createUserRequest.getPassword());
        authPage.clickLoginBottom();
        builderPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("logging in using the Login button on the registration page")
    public void testLoginFromRegistrationPage() {
        authPage.clickPersonalAccountBottom();
        authPage.clickRegBottom();
        authPage.clickLoginInRegBottom();
        authPage.setEmailField(createUserRequest.getEmail());
        authPage.setPasswordField(createUserRequest.getPassword());
        authPage.clickLoginBottom();
        builderPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("logging in using the Login button on the password recovery page")
    public void testLoginFromForgotPasswordPage() {
        authPage.clickPersonalAccountBottom();
        authPage.clickForgotPasswordBottom();
        authPage.clickLoginInRegBottom();
        authPage.setEmailField(createUserRequest.getEmail());
        authPage.setPasswordField(createUserRequest.getPassword());
        authPage.clickLoginBottom();
        builderPage.checkMakeYourBurgerIsDisplayed();
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