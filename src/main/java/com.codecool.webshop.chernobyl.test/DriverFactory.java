package com.codecool.webshop.chernobyl.test;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverFactory {

    public static WebDriver getWebDriver(String browser) {

        switch (browser) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            case "IE":
                throw new IllegalArgumentException("C'mon nobody uses IE");
            default:
                throw new InvalidArgumentException("Sorry " + browser + " is not an option.");
        }
    }
}
