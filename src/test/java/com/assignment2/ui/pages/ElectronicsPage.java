package com.assignment2.ui.pages;

import com.assignment2.ui.maps.ElectronicsMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage extends BaseClass {

    ElectronicsMap electronicsMap = new ElectronicsMap();

    /**
     * This method click on Electronics come in Navbar
     */
    public void clickElectronicsButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(electronicsMap.electronicsButton())).click().perform();
        //driver.findElement(electronicsMap.electronicsButton()).click();
    }

    /**
     * This method click on Cell phone Image
     */
    public void clickCellPhonesImage(){
        driver.findElement(electronicsMap.cellPhonesImage()).click();
    }

    public void clickProductImage(String productId){
        driver.findElement(electronicsMap.productImage(productId)).click();
    }

    public void clickAddToCartButton(String productId){
        driver.findElement(electronicsMap.addToCart(productId)).click();
    }

    public void clickAddToWishlistButton(String productId){
        driver.findElement(electronicsMap.addToWishlistButton(productId)).click();
    }
}
