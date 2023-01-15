package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends MainPage {

    public final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By loginBottom = By.xpath(".//button[(text()='Войти')]");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By entryHeader = By.xpath("//h2[text()='Вход']");
    private final By builderBottom = By.linkText("Конструктор");
    private final By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");

    public PersonalDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        webDriver.get(MAIN_URL);
    }

    public void clickLoginBottom() {
        webDriver.findElement(loginBottom).click();
    }

    public void clickLoginAccountBottom() {
        webDriver.findElement(loginAccountButton).click();
    }

    public void clickLogo() {
        webDriver.findElement(stellarBurgerLogo).click();
    }

    public void clickBuilderBottom() {
        webDriver.findElement(builderBottom).click();
    }

    public void setEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void checkEntryHeaderIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(entryHeader).isDisplayed());
    }
}