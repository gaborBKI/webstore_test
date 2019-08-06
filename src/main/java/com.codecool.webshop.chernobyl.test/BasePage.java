package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    public static void main(String[] args) {

    }
}
