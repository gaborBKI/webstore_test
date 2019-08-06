package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasePage {
    protected WebDriver driver = new FirefoxDriver();

    public void open(String url){
        driver.get(url);

    }
}
