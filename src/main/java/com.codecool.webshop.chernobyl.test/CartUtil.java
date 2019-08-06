package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartUtil extends BasePage {

    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']") private WebElement elementInCart;
    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']//a") private WebElement amountInCart;
    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']//td[@class='productTotal']") private WebElement elementPriceInCart;


    public CartUtil(WebDriver driver) {
        super(driver);
    }

    public String getElementInCartQuantity(){
        return amountInCart.getText();
    }

    public String getElementInCartPrice(){
        return elementPriceInCart.getText();
    }
}
