package ChernobylTest;

import com.codecool.webshop.chernobyl.test.BasePage;
import com.codecool.webshop.chernobyl.test.CartUtil;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import static org.junit.jupiter.api.Assertions.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReviewCartTest {

    private static CartUtil cartUtil = new CartUtil(DriverFactory.getWebDriver(BasePage.getBrowser()));

    @Given("I have a Shopping Cart with items in it")
    public void iHaveAShoppingCartWithItemsInIt() {
        cartUtil.open(BasePage.getBaseUrl() + "review");
        cartUtil.emptyCart();
        cartUtil.backToIndex();
        cartUtil.addItemToCart();
    }

    @When("I click on the Shopping cart menu item in the Page header")
    public void iClickOnTheMenuItemInThePageHeader() {
        cartUtil.openShoppingCart();
    }

    @Then("ensure it displays the items \\(LineItems) with the following data {string}, {string}. {string}")
    public void ensureItDisplaysTheItemsLineItemsWithTheFollowingData(String expectedName, String expectedQuantity, String expectedPrice) {
        assertEquals(expectedName, cartUtil.getItemNameInCart());
        assertEquals(expectedQuantity, cartUtil.getItemQuantityInCart());
        assertEquals(expectedPrice, cartUtil.getItemPriceInCart());
    }

    @And("ensure it displays the total price of all the items in the cart")
    public void ensureItDisplaysTheTotalPriceOfAllTheItemsInTheCart() {
        assertNotNull(cartUtil.getTotalPriceOfCart());
        cartUtil.close();
    }

}
