package ChernobylTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutStepDefs {

    @Given("^I have a Shopping Cart review page$")
    public void I_have_shopping_cart_review_page() {

    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String checkoutButton) {
    }

    @Then("ensure it asks the following data from the User: Name, Email, Phone number, Billing Address, Shipping Address")
    public void ensureItAsksDataFromTheUser() {
    }

    @And("it stores the validated data to the Order")
    public void itStoresTheValidatedDataToTheOrder() {
    }


    @And("it redirects to the Payment page")
    public void itRedirectsToThePaymentPage() {
    }
}
