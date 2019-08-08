package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public abstract class BasePage {

    private static final String BASE_URL = "http://localhost:8080/";
    private static final String BROWSER = System.getenv("BROWSER");

    @FindBy(id = "products") private WebElement products;
    @FindBy(id = "1") private WebElement addFireTruckButton;
    @FindBy(id = "shopping_cart") private WebElement shoppingCart;
    @FindBy(id = "products") private WebElement productList;

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

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getBrowser(){
        return BROWSER;
    }

    public void open(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public boolean checkProductHasAddToCartButton(){
        try {
            Waiter.waitForElement(driver, addFireTruckButton);
        } catch (TimeoutException e){
            return false;
        }
        return true;
    };

    public void addItemToCart(){
        try {
            Objects.requireNonNull(Waiter.waitForElement(driver, addFireTruckButton)).click();
        } catch (TimeoutException e){
            throw new TimeoutException("Element not found");
        }
    }

    public WebElement getProductList(){
        return Waiter.waitForElement(driver, productList);
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

    public void close(){
        driver.quit();
    };
}
