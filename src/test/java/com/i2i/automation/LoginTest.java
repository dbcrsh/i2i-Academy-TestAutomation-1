package com.i2i.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void kurulum() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void basarili_Login_Testi() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(6000);
    }

    @AfterMethod
    public void kapatis() {
        if (driver != null) {
            driver.quit();
        }
    }
}