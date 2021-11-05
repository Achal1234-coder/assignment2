package com.assignment2.ui.pages;

import com.assignment2.ui.maps.NavMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NavPage extends BaseClass {

    NavMap navMap = new NavMap();

    /**
     * This method click on register Button
     */
    public void clickRegisterNavbar(){
        driver.findElement(navMap.registerNavbar()).click();
    }

    /**
     * This method hover on Shopping Card  Navbar
     */
    public void hoverShoppingCardNavbar(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(navMap.shoppingCardNavbar())).perform();
    }

    /**
     *
     */
    public void assertOfTotalItemsInShoppingCart(String totalProduct){
            String text = driver.findElement(navMap.totalItemsInShoppingCart()).getText();
            System.out.println(text);
            System.out.println("hello");
            String actualTotalProduct = text.split("[()]")[1];
            Assert.assertEquals(actualTotalProduct, totalProduct);
    }

    public void clickGoToCartButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(navMap.goToCartButton())).click();
    }

    public void clickCartNotificationCloseButton(){
        driver.findElement(navMap.cartNotificationCloseButton()).click();
    }

    public void waitForAddCartNotification(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(navMap.addCartNotification()));
    }

    public void clickWishListNavbar(){
        try {
            driver.findElement(navMap.wishListNavbar()).click();
        }
        catch (Exception e) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(navMap.wishListNavbar())).click().perform();
        }
    }

}
