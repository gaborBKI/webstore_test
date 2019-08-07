package ChernobylTest;

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

    private static final CartPage CART_PAGE = new CartPage(DriverFactory.getWebDriver(System.getenv("BROWSER")));
    private static final Waiter waiter = new Waiter();
    private String itemCounterId = "basketItemCounter";

    @After // ???
    public static void tearDown(){
        CART_PAGE.close();
    }

    @Given("my cart in the shop is empty.")
    public void emptyCart() {
        CART_PAGE.open(System.getenv("BASE_URL") + "review");
        CART_PAGE.emptyCart();
    }

    @And("I am on the index page.")
    public void iAmOnTheIndexPage() {
        CART_PAGE.backToIndex();
    }

    @Given("I have a Product list")
    public void verifyProductListAppears() {
        CART_PAGE.open(System.getenv("BASE_URL"));
    }

    @And("the Products have an Add to Cart button")
    public void verifyAddButtonExists() {
        assertTrue(CART_PAGE.checkProductHasAddToCartButton());
    }

    @When("I click on the Add to Cart button of the {string} product")
    public void addProductToCart(String productName) {
        CART_PAGE.addToCart(System.getenv("PRODUCT_BUTTON_ID"));
    }

    @Then("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(int expectedQuantity, String expectedPrice) {
        CART_PAGE.openShoppingCart();
        assertEquals(String.valueOf(expectedQuantity), CART_PAGE.getElementInCartQuantity());
        assertEquals(expectedPrice, CART_PAGE.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {
        CART_PAGE.open(System.getenv("BASE_URL"));
        CART_PAGE.refresh();
        assertNotNull(CART_PAGE.getElementById(itemCounterId).getText());
    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounter = CART_PAGE.getElementText(CART_PAGE.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
    }
}
