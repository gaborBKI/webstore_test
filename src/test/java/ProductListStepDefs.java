import com.codecool.webshop.chernobyl.test.ProductUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductListStepDefs {
    ProductUtil productUtil = new ProductUtil();
    @Given("I have Products and a default Product Category in the application")
    public void iHaveProductsAndADefaultProductCategoryInTheApplication() {
    }


    @When("I open the root url")
    public void iOpenTheRootUrl() {
        productUtil.open("http://localhost:8080/");

    }
    

    @Then("ensure I can see a list of Products")
    public void ensureICanSeeAListOfProducts() {
    }

    @And("ensure that the following details are displayed: product title, description, image, price")
    public void ensureThatTheFollowingDetailsAreDisplayedProductTitleDescriptionImagePrice() {
    }


}
