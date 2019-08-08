package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;

import static org.junit.Assert.*;

public class ProductFilterBySupplierStepDefs {
    private static ProductPage PRODUCT_PAGE = new ProductPage(DriverFactory.getWebDriver(System.getenv("BROWSER")));


    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
        PRODUCT_PAGE.open("http://localhost:8080/");
        PRODUCT_PAGE.findSupplierDropDown();
    }


    @When("I I click on a {string}")
    public void iIClickOnA(String supplierName) {
        PRODUCT_PAGE.selectSupplierName(supplierName);
        PRODUCT_PAGE.clickToSearch();
    }

    @Then("ensure it displays the {string} only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier(String expectedNumber) {
        int actualNumber = PRODUCT_PAGE.countProducts();
        assertEquals(Integer.parseInt(expectedNumber), actualNumber);
    }

    @After
    public static void tearDown(){
        PRODUCT_PAGE.close();
    }


}
