package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private final int TIMEOUT = 10;

    public WebElement waitForElementById(WebDriver driver, String id){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return element;
    }

}
