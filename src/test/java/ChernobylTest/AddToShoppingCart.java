package ChernobylTest;

import com.codecool.webshop.chernobyl.test.BasePage;
import com.codecool.webshop.chernobyl.test.CartPage;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;

public class AddToShoppingCart {

    private static CartPage cartPage = new CartPage(DriverFactory.getWebDriver(BasePage.getBrowser()));
    private String itemCounterId = "basketItemCounter";

    @Given("my cart in the shop is empty.")
    public void emptyCart() {
        cartPage.open(BasePage.getBaseUrl() + "review");
        cartPage.emptyCart();
        cartPage.backToIndex();
    }

    @Given("I have a Product list")
    public void verifyProductListAppears() {
        assertNotNull(cartPage.getProductList());
    }

    @And("the Products have an Add to Cart button")
    public void verifyAddButtonExists() {
        assertTrue(cartPage.checkProductHasAddToCartButton());
    }

    @When("I click on the Add to Cart button of the {string} product")
    public void addProductToCart(String productName) {
        cartPage.addItemToCart();
    }

    @Then("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(int expectedQuantity, String expectedPrice) {
        cartPage.openShoppingCart();
        assertEquals(String.valueOf(expectedQuantity), cartPage.getElementInCartQuantity());
        assertEquals(expectedPrice, cartPage.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {
        cartPage.backToIndex();
        cartPage.refresh();
        assertNotNull(cartPage.getElementById(itemCounterId).getText());
    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounter = cartPage.getElementText(cartPage.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
        cartPage.close();
    }
}
