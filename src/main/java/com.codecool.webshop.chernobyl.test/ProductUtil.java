package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductUtil extends BasePage {


    public ProductUtil(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='products']//descendant::div[@class='card']") private List<WebElement> products;


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
}
