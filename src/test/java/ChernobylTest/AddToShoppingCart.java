package ChernobylTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToShoppingCart {
    @Given("I have a Product list")
    public void verifyProducListAppears() {

    }

    @And("the Products have an {string} button")
    public void verifyAddButtonExists(String buttonText) {

    }

    @When("I click on the {string} button of the {string} product")
    public void addProductToCart(String arg0, String arg1) {

    }


    @Then("ensure it creates a new Order for storing cart data of the User")
    public void verifyProductInCart() {

    }

    @And("ensure it creates a new LineItem with the quantity of {int} and price {string}")
    public void ensureItCreatesANewLineItemWithTheQuantityOfAndPrice(int arg0, String arg1) {

    }

    @And("ensure it stores this data on the server.")
    public void verifyProductDataPersistent() {

    }

    @And("ensure it displays the number of cart items in the Page header.")
    public void verifyCartDisplaysContentAmount() {

    }
}
