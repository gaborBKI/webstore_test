package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static final int TIMEOUT = 10;

    public static WebElement waitForElementById(WebDriver driver, String id){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static WebElement waitForElementByText(WebDriver driver, String text){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='review-table']//td[text()=" + text + "]")));
    }

    public static WebElement waitForElement(WebDriver driver, WebElement element, int time ){
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElement(WebDriver driver, WebElement element ){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            return null;
        }

    }

}
