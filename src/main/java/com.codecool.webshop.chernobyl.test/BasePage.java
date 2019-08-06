package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    /*

    Accepts a System.getenv("BROWSER") value. The environment variable can be:
        FIREFOX or
        CHROME

     */

    private WebDriver driver = DriverFactory.getWebDriver(System.getenv("BROWSER"));

    public void open(String url){
        driver.get(url);
    }

    protected void waitFor(WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
