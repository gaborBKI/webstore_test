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

public class ReviewCartTest {

    private static CartPage cartPage = new CartPage(DriverFactory.getWebDriver(BasePage.getBrowser()));

    @Given("I have a Shopping Cart with items in it")
    public void iHaveAShoppingCartWithItemsInIt() {
        cartPage.open(BasePage.getBaseUrl() + "review");
        cartPage.emptyCart();
        cartPage.backToIndex();
        cartPage.addItemToCart();
    }

    @When("I click on the Shopping cart menu item in the Page header")
    public void iClickOnTheMenuItemInThePageHeader() {
        cartPage.openShoppingCart();
    }

    @Then("ensure it displays the items \\(LineItems) with the following data {string}, {string}. {string}")
    public void ensureItDisplaysTheItemsLineItemsWithTheFollowingData(String expectedName, String expectedQuantity, String expectedPrice) {
        assertEquals(expectedName, cartPage.getItemNameInCart());
        assertEquals(expectedQuantity, cartPage.getItemQuantityInCart());
        assertEquals(expectedPrice, cartPage.getItemPriceInCart());
    }

    @And("ensure it displays the total price of all the items in the cart")
    public void ensureItDisplaysTheTotalPriceOfAllTheItemsInTheCart() {
        assertNotNull(cartPage.getTotalPriceOfCart());
        cartPage.close();
    }

}
