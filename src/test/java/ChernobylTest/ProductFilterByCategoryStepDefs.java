package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductFilterByCategoryStepDefs {
    private static ProductUtil PRODUCT_PAGE = new ProductUtil(DriverFactory.getWebDriver(System.getenv("BROWSER")));

    @Given("I have Products and Product Categories listed on the index page")
    public void iHaveProductsAndProductCategoriesListedOnTheIndexPage() {
        PRODUCT_PAGE.open("http://localhost:8080/");
        PRODUCT_PAGE.findCategoryDropDown();

    }

    @When("I I click on a Category's {string}")
    public void iIClickOnACategoryS(String categoryName) {
        PRODUCT_PAGE.selectProductCategory(categoryName);
        PRODUCT_PAGE.clickToSearch();
    }

    @Then("ensure it displays the {string} only in the selected Category")
    public void ensureItDisplaysTheOnlyInTheSelectedCategory(String expectedNumber) {
        int actualNumber = PRODUCT_PAGE.countProducts();
        assertEquals(Integer.parseInt(expectedNumber), actualNumber);
        PRODUCT_PAGE.closeWindow();
    }
}
