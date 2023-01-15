package pageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuilderPage extends MainPage {

    private final By bunSection = By.xpath("//span[text()='Булки']");
    private final By sauceSection = By.xpath("//span[text()='Соусы']");
    private final By toppingSection = By.xpath("//span[text()='Начинки']");
    private final By activeSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");

    public BuilderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("click on section Buns")
    public void clickBunSection() {
        webDriver.findElement(bunSection).click();
    }

    @Step("click on section Sauces")
    public void clickSauceSection() {
        webDriver.findElement(sauceSection).click();
    }

    @Step("click on section Toppings")
    public void clickToppingSection() {
        webDriver.findElement(toppingSection).click();
    }

    public void checkMakeYourBurgerIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(makeYourBurgerHeader).isDisplayed());
    }

    public String textFromActiveSection() {
        return webDriver.findElement(activeSection).getText();
    }
}