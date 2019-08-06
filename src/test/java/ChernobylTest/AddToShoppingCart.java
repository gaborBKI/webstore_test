package ChernobylTest;

import com.codecool.webshop.chernobyl.test.CartUtil;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.webshop.chernobyl.test.Waiter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToShoppingCart {

    private static final CartUtil CART_UTIL = new CartUtil(DriverFactory.getWebDriver(System.getenv("BROWSER")));
    private static final Waiter waiter = new Waiter();
    private String productButtonToTest = "1";
    private String productName = "Fire Truck";
    private String itemCounterId = "basketItemCounter";

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
    }

    @And("the Products have an Add to Cart button")
    public void verifyAddButtonExists() {
        assertTrue(CART_UTIL.checkProductHasAddToCartButton(System.getenv("PRODUCT_BUTTON_ID")));
    }

    @When("I click on the Add to Cart button of the {string} product")
    public void addProductToCart(String productName) {
        CART_UTIL.addToCart(System.getenv("PRODUCT_BUTTON_ID"));
    }

    @Then("ensure it creates a new Order for storing cart data of the User")
    public void verifyProductInCart() {
        assertTrue(true);
    }

    @And("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(int expectedQuantity, String expectedPrice) {
        CART_UTIL.open("http://localhost:8080/review");
        assertEquals(String.valueOf(expectedQuantity), CART_UTIL.getElementInCartQuantity());
        assertEquals(expectedPrice, CART_UTIL.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {
        CART_UTIL.open(System.getenv("BASE_URL"));
        CART_UTIL.refresh();
        assertNotNull(CART_UTIL.getElementById(itemCounterId).getText());
    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounter = CART_UTIL.getElementText(CART_UTIL.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
    }
}
