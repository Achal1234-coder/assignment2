package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class WishlistMap {
    public By addToCartCheckbox(String productIndexInWishlist){
        String locator = String.format("tr:nth-child(%s) [name=\"addtocart\"]", productIndexInWishlist);
        return By.cssSelector(locator);
    }

    public By addToCartButton(){
        return By.cssSelector(".wishlist-add-to-cart-button");
    }
}
