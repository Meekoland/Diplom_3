package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends MainPage {

    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginInRegBottom = By.xpath("//a[text()='Войти']");
    private final By loginBottom = By.xpath("//button[text()='Войти']");
    private final By regBottom = By.xpath("//a[text()='Зарегистрироваться']");
    private final By forgotPasswordBottom = By.xpath("//a[text()='Восстановить пароль']");

    public AuthPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginInRegBottom() {
        webDriver.findElement(loginInRegBottom).click();
    }

    public void clickRegBottom() {
        webDriver.findElement(regBottom).click();
    }

    public void clickLoginBottom() {
        webDriver.findElement(loginBottom).click();
    }

    public void clickLoginAccountBottom() {
        webDriver.findElement(loginAccountButton).click();
    }

    public void clickPersonalAccountBottom() {
        webDriver.findElement(personalAccountButton).click();
    }

    public void clickForgotPasswordBottom() {
        webDriver.findElement(forgotPasswordBottom).click();
    }

    public void setEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }
}