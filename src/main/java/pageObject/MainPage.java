package pageObject;

import org.openqa.selenium.WebDriver;

public abstract class MainPage {

    protected WebDriver webDriver;

    protected MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}