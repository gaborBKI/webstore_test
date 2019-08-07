package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    private Waiter waiter;

    /*

    Accepts a System.getenv("BROWSER") value. The environment variable can be:
        FIREFOX or
        CHROME

     */

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        waiter = new Waiter();
    }

    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.quit();
    };

    public boolean checkProductsAppear(){
        try {
            waiter.waitForElementById(driver, "products");
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean checkProductHasAddToCartButton(String productButtonId){
        try {
            waiter.waitForElementById(driver, productButtonId);
        } catch (TimeoutException e){
            return false;
        }
        return true;
    };

    public void addToCart(String productButtonId){
        try {
            waiter.waitForElementById(driver, productButtonId).click();
        } catch (TimeoutException e){
            throw new TimeoutException("Element not found");
        }
    }

    public WebElement getElementById(String id){
        return waiter.waitForElementById(driver, id);
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
