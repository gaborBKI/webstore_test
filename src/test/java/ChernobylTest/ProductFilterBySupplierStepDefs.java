package ChernobylTest;

import com.codecool.webshop.chernobyl.test.BasePage;
import com.codecool.webshop.chernobyl.test.DriverFactory;
import com.codecool.webshop.chernobyl.test.ProductUtil;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class ProductFilterBySupplierStepDefs {
    private static ProductUtil productUtil = new ProductUtil(DriverFactory.getWebDriver(BasePage.getBrowser()));

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
        productUtil.open(BasePage.getBaseUrl());
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
