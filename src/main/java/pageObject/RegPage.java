package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPage extends MainPage {

    private final By regName = By.xpath("//fieldset[1]//input");
    private final By regEmail = By.xpath("//fieldset[2]//input");
    private final By regPassword = By.xpath("//fieldset[3]//input");
    private final By shortPasswordError = By.xpath("//p[text()='Некорректный пароль']");
    private final By regAccountButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By regLoginButton = By.xpath("//button[text()='Войти']");

    public RegPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void clickRegAccountButton() {
        webDriver.findElement(regAccountButton).click();
    }

    public void regDataField(String name, String email, String password) {
        webDriver.findElement(regName).sendKeys(name);
        webDriver.findElement(regEmail).sendKeys(email);
        webDriver.findElement(regPassword).sendKeys(password);
    }

    public String getTextPasswordError() {
        return webDriver.findElement(shortPasswordError).getText();
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(regLoginButton).isDisplayed());
    }
}