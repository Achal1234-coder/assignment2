package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class ComputersMap {

    /**
     * This method return the locator of computer Navbar
     */
    public By computersButton(){
        return By.cssSelector(".notmobile [href='/computers']");
    }

    /**
     * This method return the locator of Notebooks Image
     * @return
     */
    public By desktopsImage(){
        return By.cssSelector("img[title='Show products in category Desktops']");
    }

    public By productImage(String productId){
        String locator = String.format("[data-productid='%s'] img",productId);
        return By.cssSelector(locator);
    }

    public By ramSelect(){
        return By.cssSelector("select#product_attribute_2");
    }

    public By hddCheckbox(){
        return By.cssSelector("input#product_attribute_3_6");
    }

    public By addToCartButton(String productId){
        String locator = String.format("button#add-to-cart-button-%s",productId);
        return By.cssSelector(locator);
    }

    public By addToWishlistButton(String productId){
        String locator = String.format("#add-to-wishlist-button-%s",productId);
        return By.cssSelector(locator);
    }

}
