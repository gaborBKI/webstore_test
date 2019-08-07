package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartUtil extends BasePage {

    @FindBy(id = "deleteAll") private WebElement deleteAllButton;
    @FindBy(id = "review") private WebElement backToHomeButton;
    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']") private WebElement elementInCart;
    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']//a") private WebElement amountInCart;
    @FindBy(xpath = "//*[@id='review-table']/tbody/tr[@data-el_id='1']//td[@class='productTotal']") private WebElement elementPriceInCart;


    public CartUtil(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void emptyCart(){
        Waiter.waitForElement(driver, deleteAllButton, 10).click();
    }

    public String getElementInCartQuantity(){
        Waiter.waitForElement(driver, elementPriceInCart, 10);
        return amountInCart.getText();
    }

    public String getElementInCartPrice(){
        Waiter.waitForElement(driver, amountInCart, 10);
        return elementPriceInCart.getText();
    }

    public void backToIndex() {
        Waiter.waitForElement(driver, backToHomeButton, 10).click();
    }
}
