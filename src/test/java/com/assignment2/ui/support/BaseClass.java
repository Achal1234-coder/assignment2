package com.assignment2.ui.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class BaseClass
{


    public static WebDriver driver;

    @BeforeMethod
    public void setupApplication()
    {

        Reporter.log("=====Browser Session Started=====", true);

        driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(" https://demo.nopcommerce.com/");

        Reporter.log("=====Application Started=====", true);
    }

    @AfterMethod
    public void closeApplication()
    {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);

    }

}
