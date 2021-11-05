package com.assignment2.ui.pages;

import com.assignment2.ui.maps.CheckoutMap;
import com.assignment2.ui.support.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends BaseClass {

    CheckoutMap checkoutMap = new CheckoutMap();

    public void clickAndEnterFirstNameTextField(String firstName){
        driver.findElement(checkoutMap.firstNameTextField()).click();
        driver.findElement(checkoutMap.firstNameTextField()).sendKeys(firstName);
    }

    public void clickAndEnterLastNameTextField(String lastName){
        driver.findElement(checkoutMap.lastNameTextField()).click();
        driver.findElement(checkoutMap.lastNameTextField()).sendKeys(lastName);
    }

    public void clickAndEnterEmailTextField(String email){
        driver.findElement(checkoutMap.emailTextField()).click();
        driver.findElement(checkoutMap.emailTextField()).sendKeys(email);
    }

    public void clickAndSelectCountry(String country){
       try {
           WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
           webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.countrySelectField()));
       }
       finally {
           Select select = new Select(driver.findElement(checkoutMap.countrySelectField()));
           select.selectByVisibleText(country);
       }
    }

    public void clickAndSelectState(String state){
       // driver.findElement(billingAddressMap.stateSelectField()).click();
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(checkoutMap.loadingWaitIcon()));
        }
        finally {
            Select select = new Select(driver.findElement(checkoutMap.stateSelectField()));
            select.selectByVisibleText(state);
        }
    }

    public void clickAndEnterCityTextField(String city){
        driver.findElement(checkoutMap.cityTextField()).click();
        driver.findElement(checkoutMap.cityTextField()).sendKeys(city);
    }

    public void clickAndEnterAddressTextField(String address){
        driver.findElement(checkoutMap.addressTextField()).click();
        driver.findElement(checkoutMap.addressTextField()).sendKeys(address);
    }

    public void clickAndEnterZipCodeTextField(String zipCode){
        driver.findElement(checkoutMap.zipCodeTextField()).click();
        driver.findElement(checkoutMap.zipCodeTextField()).sendKeys(zipCode);
    }

    public void clickAndEnterPhoneNo(String phoneNo){
        driver.findElement(checkoutMap.phoneNoTextField()).click();
        driver.findElement(checkoutMap.phoneNoTextField()).sendKeys(phoneNo);
    }

    public void clickBillingAddressContinueButton(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.billingAddressContinueButton()));
        }
        finally {
            driver.findElement(checkoutMap.billingAddressContinueButton()).click();
        }
    }

    public void clickShippingMethodContinueButton(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.shippingMethodContinueButton()));
        }
        finally {
            driver.findElement(checkoutMap.shippingMethodContinueButton()).click();
        }
    }

    public void clickPaymentMethodContinueButton(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.paymentMethodContinueButton()));
        }
        finally {
            driver.findElement(checkoutMap.paymentMethodContinueButton()).click();
        }
    }

    public void clickPaymentInformationContinueButton(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.paymentInformationContinueButton()));
        }
        finally {
            driver.findElement(checkoutMap.paymentInformationContinueButton()).click();
        }
    }

    public void clickConfirmButton(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutMap.confirmButton()));
        }
        finally {
            driver.findElement(checkoutMap.confirmButton()).click();
        }
    }

    public void assertConfirmOrder(String expectedConfirmationText){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,15);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(checkoutMap.orderConfirmationText()));
        }
        finally {
            String actualConfirmationText = driver.findElement(checkoutMap.orderConfirmationText()).getText();
            Assert.assertEquals(actualConfirmationText,expectedConfirmationText);
        }
    }

    public void clickAndSelectNewBillingAddressSelect(){
        Select select = new Select(driver.findElement(checkoutMap.newBillingAddressSelect()));
        select.selectByVisibleText("New Address");
    }
}
