package ChernobylTest;

import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductUtil;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;

import static org.junit.Assert.*;

public class ProductFilterBySupplierStepDefs {
    private ProductUtil productUtil = new ProductUtil(DriverFactory.getWebDriver(System.getenv("BROWSER")));

    @After
    public void tearDown(){
        productUtil.close();
    }

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
        productUtil.open("http://localhost:8080/");
        productUtil.findSupplierDropDown();
    }


    @When("I I click on a {string}")
    public void iIClickOnA(String supplierName) {
        productUtil.selectSupplierName(supplierName);
        productUtil.clickToSearch();
    }

    @Then("ensure it displays the {string} only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier(String expectedNumber) {
        int actualNumber = productUtil.countProducts();
        assertEquals(Integer.parseInt(expectedNumber), actualNumber);
    }


}
