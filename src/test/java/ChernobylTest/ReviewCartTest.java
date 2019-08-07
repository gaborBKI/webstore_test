package ChernobylTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReviewCartTest {

    @Given("I have a Shopping Cart with items in it")
    public void iHaveAShoppingCartWithItemsInIt() {

    }

    @When("I click on the {string} menu item in the Page header")
    public void iClickOnTheMenuItemInThePageHeader(String arg0) {
    }

    @Then("ensure it displays the items \\(LineItems) with the following data {string}, {string}. {string}")
    public void ensureItDisplaysTheItemsLineItemsWithTheFollowingData(String expectedName, String expectedQuantity, String expectedPrice) {

    }

    @And("ensure it displays the total price of all the items in the cart")
    public void ensureItDisplaysTheTotalPriceOfAllTheItemsInTheCart() {
    }
}
