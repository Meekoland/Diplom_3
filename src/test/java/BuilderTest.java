import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.BuilderPage;

public class BuilderTest extends MainTest {

    @Test
    @DisplayName("transit to section Buns")
    public void testTransitToBuns() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceSection();
        builderPage.clickBunSection();
        Assert.assertEquals("Булки", builderPage.textFromActiveSection());
    }

    @Test
    @DisplayName("transit to section Sauces")
    public void testTransitToSauces() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceSection();
        builderPage.clickBunSection();
        builderPage.clickSauceSection();
        Assert.assertEquals("Соусы", builderPage.textFromActiveSection());
    }

    @Test
    @DisplayName("transit to section Toppings")
    public void testTransitToToppings() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceSection();
        builderPage.clickBunSection();
        builderPage.clickToppingSection();
        Assert.assertEquals("Начинки", builderPage.textFromActiveSection());
    }
}