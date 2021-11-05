package com.assignment2.ui.pages;

import com.assignment2.ui.maps.ShoppingCartMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCartPage extends BaseClass {

    ShoppingCartMap shoppingCartMap = new ShoppingCartMap();

    public void clickTermOfServiceCheckbox(){
        driver.findElement(shoppingCartMap.termOfServiceCheckbox()).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(shoppingCartMap.checkoutButton()).click();
    }

    public void assertCheckoutButton(){
        driver.findElement(shoppingCartMap.checkoutButton()).click();
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartMap.termOfServiceInformationPopup()));
            Assert.assertTrue(true,"Term of service checkbox pop up is occur");
        }
        catch (Exception e){
            Assert.fail("Term of service checkbox pop up is not occur");
        }
    }
}
