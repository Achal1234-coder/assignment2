package com.assignment2.ui.pages;

import com.assignment2.ui.maps.CheckoutMap;
import com.assignment2.ui.maps.SignInMap;
import com.assignment2.ui.support.BaseClass;

public class SignInPage extends BaseClass {

    SignInMap signInMap = new SignInMap();
    CheckoutMap checkoutMap = new CheckoutMap();

    public void clickAndEnterEmailTextField(String email){
        driver.findElement(signInMap.emailTextField()).click();
        driver.findElement(signInMap.emailTextField()).sendKeys(email);
    }

    public void clickAndEnterPasswordTextField(String password){
        driver.findElement(signInMap.passwordTextField()).click();
        driver.findElement(signInMap.passwordTextField()).sendKeys(password);
    }

    public void clickLoginButton(){
        /*Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(signInMap.loginButton())).click().perform();*/
        driver.findElement(signInMap.loginButton()).click();
       // driver.findElement(signInMap.loginButton()).click();

    }
}
