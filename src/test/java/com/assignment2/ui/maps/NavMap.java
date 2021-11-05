package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class NavMap {

    /**
     * this method return the locator of register Navbar
     * @return
     */
    public By registerNavbar(){
        return By.cssSelector(".ico-register");
    }

    /**
     * This method return the locator of shopping Card Navbar
     */
    public By shoppingCardNavbar(){
        return By.cssSelector(".cart-label");
    }

    /**
     * This method return the locator of total items in Shopping Cart
     * @return
     */
    public By totalItemsInShoppingCart(){
        return By.cssSelector("span.cart-qty");
    }

    public By goToCartButton(){
        return By.cssSelector(".cart-button");
    }

    public By addCartNotification(){
        return By.cssSelector("#bar-notification");
    }

    public By cartNotificationCloseButton(){
        return By.cssSelector("[title=\"Close\"]");
    }

    public By wishListNavbar(){
        return By.cssSelector(".wishlist-label");
    }

}
