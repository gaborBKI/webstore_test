package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    private static final String ELEM_XPATH_BASE = "//*[@id='review-table']/tbody/tr[@data-el_id='1']";

    @FindBy(id = "deleteAll") private WebElement deleteAllButton;
    @FindBy(id = "review") private WebElement backToHomeButton;
    @FindBy(id = "money") private WebElement totalPrice;
    @FindBy(xpath = ELEM_XPATH_BASE) private WebElement elementInCart;
    @FindBy(xpath = ELEM_XPATH_BASE + "//td[@class='productNames']") private WebElement elementName;
    @FindBy(xpath = ELEM_XPATH_BASE + "//a") private WebElement amountInCart;
    @FindBy(xpath = ELEM_XPATH_BASE + "//td[@class='productTotal']") private WebElement elementPriceInCart;


    public CartPage(WebDriver driver) {
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

    public String getItemNameInCart() {
        return Waiter.waitForElement(driver, elementName).getText();
    }

    public String getItemQuantityInCart() {
        return Waiter.waitForElement(driver, amountInCart).getText();
    }

    public String getItemPriceInCart() {
        return Waiter.waitForElement(driver, elementPriceInCart).getText();
    }

    public String getTotalPriceOfCart(){
        return Waiter.waitForElement(driver, totalPrice).getText();
    }
}
