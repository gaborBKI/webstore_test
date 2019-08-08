package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductFilterByCategoryStepDefs {
    private static ProductUtil productUtil = new ProductUtil(DriverFactory.getWebDriver(System.getenv("BROWSER")));

    @Given("I have Products and Product Categories listed on the index page")
    public void iHaveProductsAndProductCategoriesListedOnTheIndexPage() {
        productUtil.open("http://localhost:8080/");
        productUtil.findCategoryDropDown();
    }

    @When("I I click on a Category's {string}")
    public void iIClickOnACategoryS(String categoryName) {
        productUtil.selectProductCategory(categoryName);
        productUtil.clickToSearch();
    }

    @Then("ensure it displays the {string} only in the selected Category")
    public void ensureItDisplaysTheOnlyInTheSelectedCategory(String expectedNumber) {
        int actualNumber = productUtil.countProducts();
        assertEquals(Integer.parseInt(expectedNumber), actualNumber);
    }
}
