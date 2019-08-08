package ChernobylTest;

import com.codecool.webshop.chernobyl.test.BasePage;
import com.codecool.webshop.chernobyl.test.CartUtil;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToShoppingCart {

    private static CartUtil cartUtil = new CartUtil(DriverFactory.getWebDriver(BasePage.getBrowser()));
    private String itemCounterId = "basketItemCounter";

    @Given("my cart in the shop is empty.")
    public void emptyCart() {
        cartUtil.open(BasePage.getBaseUrl() + "review");
        cartUtil.emptyCart();
        cartUtil.backToIndex();
    }

    @Given("I have a Product list")
    public void verifyProductListAppears() {
        assertNotNull(cartUtil.getProductList());
    }

    @And("the Products have an Add to Cart button")
    public void verifyAddButtonExists() {
        assertTrue(cartUtil.checkProductHasAddToCartButton());
    }

    @When("I click on the Add to Cart button of the {string} product")
    public void addProductToCart(String productName) {
        cartUtil.addItemToCart();
    }

    @Then("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void lineItemHasCorrectQuantityAndPrice(int expectedQuantity, String expectedPrice) {
        cartUtil.openShoppingCart();
        assertEquals(String.valueOf(expectedQuantity), cartUtil.getElementInCartQuantity());
        assertEquals(expectedPrice, cartUtil.getElementInCartPrice());
    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {
        cartUtil.backToIndex();
        cartUtil.refresh();
        assertNotNull(cartUtil.getElementById(itemCounterId).getText());
    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {
        String itemCounter = cartUtil.getElementText(cartUtil.getElementById(itemCounterId));
        assertEquals("1", itemCounter);
        cartUtil.quit();
    }
}
