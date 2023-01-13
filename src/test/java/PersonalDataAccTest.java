import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pageObject.BuilderPage;
import pageObject.PersonalDataPage;
import pageObject.RegPage;

public class PersonalDataAccTest extends MainTest {

    private static final String EMAIL = RandomStringUtils.randomAlphanumeric(5) + "@example.ru";
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(8);
    private static final String NAME = RandomStringUtils.randomAlphanumeric(5);

    @Test
    @DisplayName("login account with button Personal account on Main page")
    public void testEntryToPersonalAcc() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.checkEntryHeaderIsDisplayed();
    }

    @Test
    @DisplayName("transit to Builder page from Personal account page")
    public void testTransitToBuilder() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.clickBuilderBottom();
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("transit to Builder page from Personal account page through the logo")
    public void testTransitLogoToBuilder() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.clickLogo();
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("login Personal account with button Sign in on Main page")
    public void testEntryOnMainPageButton() {
        RegPage regPage = new RegPage(webDriver);
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        BuilderPage builderPage = new BuilderPage(webDriver);
        regPage.openRegPage();
        regPage.regDataField(NAME, EMAIL, PASSWORD);
        regPage.clickRegAccountButton();
        personalDataPage.openMainPage();
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.setEmailField(EMAIL);
        personalDataPage.setPasswordField(PASSWORD);
        personalDataPage.clickLoginBottom();
        builderPage.checkMakeYourBurgerIsDisplayed();
    }
}