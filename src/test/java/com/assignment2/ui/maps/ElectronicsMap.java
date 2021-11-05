package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class ElectronicsMap {

    /**
     * This method return the locator of Electronics locator On navbar
     * @return
     */
    public By electronicsButton(){
        return By.cssSelector(".notmobile [href='/electronics']");
    }

    /**
     * This method return the locator of cell Phone Image
     * @return
     */
    public By cellPhonesImage(){
        return By.cssSelector("[alt='Picture for category Cell phones']");
    }

    public By productImage(String productId){
        String locator = String.format("[data-productid='%s'] img",productId);
        return By.cssSelector(locator);
    }

    public By addToCart(String productId){
        String locator = String.format("button#add-to-cart-button-%s",productId);
        return By.cssSelector(locator);
    }

    public By addToWishlistButton(String productId){
        String locator = String.format("#add-to-wishlist-button-%s",productId);
        return By.cssSelector(locator);
    }

}
