package ChernobylTest;

import com.codecool.webshop.chernobyl.test.CartUtil;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.webshop.chernobyl.test.Waiter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AddToShoppingCart {

    private static final CartUtil CART_UTIL = new CartUtil(DriverFactory.getWebDriver(System.getenv("BROWSER")));
    private static final Waiter waiter = new Waiter();
    private String productButtonToTest = "1";
    private String productName = "Fire Truck";

    /*@BeforeAll
    public static void setUp(){
        CART_UTIL.open(System.getenv("BASE_URL"));
    }

    @AfterAll // ???
    public static void tearDown(){
        CART_UTIL.close();
    }*/

    @Given("I have a Product list")
    public void verifyProductListAppears() {
        CART_UTIL.open(System.getenv("BASE_URL"));
        assertTrue(CART_UTIL.checkProductsAppear());
    }

    @And("the Products have an {string} button")
    public void verifyAddButtonExists() {
        assertTrue(CART_UTIL.checkProductHasAddToCartButton(System.getenv("PRODUCT_BUTTON_ID")));
    }

    @When("I click on the {string} button of the {string} product")
    public void addProductToCart(String arg0, String arg1) {
        CART_UTIL.addToCart(System.getenv("PRODUCT_BUTTON_ID"));
    }

    @Then("ensure it creates a new Order for storing cart data of the User")
    public void verifyProductInCart() {

    }

    @And("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(String expectedQuantity, String expectedPrice) {
        assertEquals(expectedQuantity, CART_UTIL.getElementInCartQuantity());
        assertEquals(expectedPrice, CART_UTIL.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {

    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounterId = "basketItemCounter";
        String itemCounter = CART_UTIL.getElementText(CART_UTIL.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
        CART_UTIL.close();
    }
}
