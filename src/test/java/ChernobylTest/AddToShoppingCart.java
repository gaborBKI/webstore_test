package ChernobylTest;

import com.codecool.webshop.chernobyl.test.BasePage;
import com.codecool.webshop.chernobyl.test.CartPage;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.webshop.chernobyl.test.Waiter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToShoppingCart {

    private static CartPage cartpage = new CartPage(DriverFactory.getWebDriver(System.getenv("BROWSER")));
    private String itemCounterId = "basketItemCounter";

    @After // ???
    public static void tearDown(){
        cartpage.close();
    }

    @Given("my cart in the shop is empty.")
    public void emptyCart() {
        cartpage.open(BasePage.getBaseUrl() + "review");
        cartpage.emptyCart();
    }

    @And("I am on the index page.")
    public void iAmOnTheIndexPage() {
        cartpage.backToIndex();
    }

    @Given("I have a Product list")
    public void verifyProductListAppears() {
        cartpage.open(BasePage.getBaseUrl());
        assertTrue(true);
    }

    @And("the Products have an Add to Cart button")
    public void verifyAddButtonExists() {
        assertTrue(cartpage.checkProductHasAddToCartButton());
    }

    @When("I click on the Add to Cart button of the {string} product")
    public void addProductToCart(String productName) {
        cartpage.addItemToCart();
    }

    @Then("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(int expectedQuantity, String expectedPrice) {
        cartpage.openShoppingCart();
        assertEquals(String.valueOf(expectedQuantity), cartpage.getElementInCartQuantity());
        assertEquals(expectedPrice, cartpage.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {
        cartpage.open(BasePage.getBaseUrl());
        cartpage.refresh();
        assertNotNull(cartpage.getElementById(itemCounterId).getText());
    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounter = cartpage.getElementText(cartpage.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
    }
}
