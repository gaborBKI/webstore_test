package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(id = "1") private WebElement addFireTruckButton;
    @FindBy(id = "shopping_cart") private WebElement shoppingCart;

    protected WebDriver driver;

    /*

    Accepts a System.getenv("BROWSER") value. The environment variable can be:
        FIREFOX or
        CHROME

     */

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.quit();
    };

    public boolean checkProductsAppear(){
        try {
            Waiter.waitForElementById(driver, "products");
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean checkProductHasAddToCartButton(String productButtonId){
        try {
            Waiter.waitForElementById(driver, productButtonId);
        } catch (TimeoutException e){
            return false;
        }
        return true;
    };

    public void addToCart(String productButtonId){
        try {
            Waiter.waitForElement(driver, addFireTruckButton, 10).click();
        } catch (TimeoutException e){
            throw new TimeoutException("Element not found");
        }
    }

    public WebElement getElementById(String id){
        return Waiter.waitForElementById(driver, id);
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

    public void openShoppingCart(){
        shoppingCart.click();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
