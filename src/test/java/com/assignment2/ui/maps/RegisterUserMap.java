package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class RegisterUserMap {


    /**
     * This method return the locator of first Name input field of user Registration
     * @return
     */
    public By firstNameTextField(){
        return By.cssSelector("#FirstName");
    }

    /**
     * This method return the locator of last Name input field of user Registration
     * @return
     */
    public By lastNameTextField(){
        return By.cssSelector("#LastName");
    }

    /**
     * This method return the locator of email input field of user Registration
     * @return
     */
    public By emailTextField(){
        return By.cssSelector("#Email");
    }

    /**
     * This method return the locator of password field of user registration
     * @return
     */
    public By passwordTextField(){
        return By.cssSelector("#Password");
    }

    /**
     * This Method return the locator of confirm password of user registration
     * @return
     */
    public By confirmPasswordTextField(){
        return By.cssSelector("#ConfirmPassword");
    }

    /**
     * This method return the locator of register Button
     * @return
     */
    public By registerButton(){
        return By.cssSelector("#register-button");
    }

    /**
     * This method return the locator of Your registration completed text
     * @return
     */
    public By confirmationOfUserRegistration(){
        return By.cssSelector(".page-body>.result");
    }

}
