package com.assignment2.ui.pages;

import com.assignment2.ui.maps.ComputersMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.support.ui.Select;

public class ComputersPage extends BaseClass {

    ComputersMap computersMap = new ComputersMap();

    /**
     * This method click on the Computer Navbar
     */
    public void clickComputerButton(){
        driver.findElement(computersMap.computersButton()).click();
    }

    /**
     * This method click on Note books Image in Computer side
     */
    public void clickDesktopsImage(){
        driver.findElement(computersMap.desktopsImage()).click();
    }

    public void clickProductImage(String productId){
        driver.findElement(computersMap.productImage(productId)).click();
    }

    public void clickRamSelect(String ram){
        Select select = new Select(driver.findElement(computersMap.ramSelect()));
        select.selectByVisibleText(ram);
    }

    public void clickHddCheckbox(){
        driver.findElement(computersMap.hddCheckbox()).click();
    }

    public void clickAddToCartButton(String productId){
        driver.findElement(computersMap.addToCartButton(productId)).click();
    }

    public void clickAddToWishlistButton(String productId){
        driver.findElement(computersMap.addToWishlistButton(productId)).click();
    }
}
