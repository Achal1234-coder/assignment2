package com.assignment2.ui.pages;

import com.assignment2.ui.maps.WishlistMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BaseClass {

    WishlistMap wishlistMap = new WishlistMap();

    public void clickAddToCartCheckbox(String productIndexInWishlist){
        /*try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(wishlistMap.addToCartCheckbox(productIndexInWishlist)));
        }
        finally {*/
            driver.findElement(wishlistMap.addToCartCheckbox(productIndexInWishlist)).click();
        //}
    }

    public void clickAddToCartButton(){
        driver.findElement(wishlistMap.addToCartButton()).click();
    }
}
