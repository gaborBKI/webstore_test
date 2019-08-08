package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class ProductFilterBySupplierStepDefs {
    private ProductPage productPage = new ProductPage(DriverFactory.getWebDriver(System.getenv("BROWSER")));

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
        productPage.open("http://localhost:8080/");
        productPage.findSupplierDropDown();
    }


    @When("I I click on a {string}")
    public void iIClickOnA(String supplierName) {
        productPage.selectSupplierName(supplierName);
        productPage.clickToSearch();
    }

    @Then("ensure it displays the {string} only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier(String expectedNumber) {
        int actualNumber = productPage.countProducts();
        assertEquals(Integer.parseInt(expectedNumber), actualNumber);
    }


}
