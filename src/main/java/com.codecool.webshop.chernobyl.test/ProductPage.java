package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='products']//descendant::div[@class='card']") private List<WebElement> products;
    @FindBy(id = "productCat") private  WebElement productCatSelect;
    @FindBy(id = "supplierCat") private WebElement supplierCatSelect;
    @FindBy(xpath = "//input[@id='filterBasket']//following-sibling::input") private WebElement filterSubbmitButton;


    public boolean checkIfProductsExist() {
        Waiter.waitForElement(driver, products.get(0), 10);
        return products != null;
    }

    public boolean testDetailsOnProducts() {
        boolean missingDetail = false;
        WebElement image;
        String title;
        String description;
        String price;


        for (WebElement product : products) {
            image = product.findElement(By.xpath("./img"));
            title = product.findElement(By.xpath(".//descendant::h4[@class='card-title']")).getText();
            description = product.findElement(By.xpath(".//descendant::p[@class='card-text']")).getText();
            price = product.findElement(By.xpath(".//descendant::p[@class='lead']")).getText();
            if(image != null && title != null && description != null && price != null){
                missingDetail = false;
            }
            else {
                missingDetail = true;
            }
        }

        return missingDetail;
    }

    public void findSupplierDropDown() {
        Waiter.waitForElement(driver, supplierCatSelect, 4);

    }
    public void findCategoryDropDown(){
        Waiter.waitForElement(driver, productCatSelect, 4);
    }

    public void selectSupplierName(String supplierName) {
        Select supplierSelect = new Select(supplierCatSelect);
        for (WebElement option : supplierSelect.getOptions()) {
            if(option.getText().equals(supplierName)) option.click();
        }
    }

    public int countProducts() {
        Waiter.waitForElement(driver, products.get(0), 10);
        int counter = 0;
        for (WebElement product : products) {
            counter++;
        }
        return counter;
    }

    public void clickToSearch() {
        filterSubbmitButton.click();
    }


    public void selectProductCategory(String productName) {
        Select productSelect = new Select(productCatSelect);
        for (WebElement option : productSelect.getOptions()) {
            if(option.getText().equals(productName)) option.click();
        }
    }

}
