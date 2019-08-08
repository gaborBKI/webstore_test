package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;


public class ProductListStepDefs {
    private ProductPage productPage = new ProductPage(DriverFactory.getWebDriver(System.getenv("BROWSER")));

    @Given("I have Products and a default Product Category in the application")
    public void iHaveProductsAndADefaultProductCategoryInTheApplication() {
    }


    @When("I open the root url")
    public void iOpenTheRootUrl() {
        productPage.open("http://localhost:8080/");

    }

    @Then("ensure I can see a list of Products")
    public void ensureICanSeeAListOfProducts() {
        assertTrue(productPage.checkIfProductsExist());
    }

    @Then("ensure that the following details are displayed: product title, description, image, price")
    public void ensureThatTheFollowingDetailsAreDisplayedProductTitleDescriptionImagePrice() {
        assertFalse(productPage.testDetailsOnProducts());
        productPage.close();
    }


}
