package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class ShoppingCartMap {

    public By termOfServiceCheckbox(){
        return By.cssSelector("input#termsofservice");
    }

    public By checkoutButton(){
        return By.cssSelector("button#checkout");
    }

    public By termOfServiceInformationPopup(){
        return By.cssSelector("div#terms-of-service-warning-box");
    }
}
