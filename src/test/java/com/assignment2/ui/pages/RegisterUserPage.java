package com.assignment2.ui.pages;

import com.assignment2.ui.support.BaseClass;
import com.assignment2.ui.maps.RegisterUserMap;
import com.assignment2.ui.support.ExcelDataProvider;
import org.testng.Assert;

import java.io.IOException;
import java.util.Random;

public class RegisterUserPage extends BaseClass {

    RegisterUserMap registerUserMap = new RegisterUserMap();
    ExcelDataProvider excelDataProvider = new ExcelDataProvider();
    Random random = new Random();

    /**
     * This method click and Enter the First name Of user in First input field
     * @param firstName
     */
    public void clickAndEnterFirstNameText(String firstName){
        driver.findElement(registerUserMap.firstNameTextField()).click();
        driver.findElement(registerUserMap.firstNameTextField()).sendKeys(firstName);
    }

    /**
     * This method click and Enter the last name Of user in Last input field
     * @param lastName
     */
    public void clickAndEnterLastNameText(String lastName){
        driver.findElement(registerUserMap.lastNameTextField()).click();
        driver.findElement(registerUserMap.lastNameTextField()).sendKeys(lastName);
    }

    /**
     * This method click and Enter the email of user in the email input field
     * @param emailHolderName
     */
    public void clickAndEnterEmailTextField(String emailHolderName, String filePath, String sheet) throws IOException {
        String email = emailHolderName + String.valueOf(random.nextInt(3000)) + "@gmail.com";
        driver.findElement(registerUserMap.emailTextField()).click();
        driver.findElement(registerUserMap.emailTextField()).sendKeys(email);
        excelDataProvider.writeExcel(filePath,sheet,email,6);
    }

    /**
     * This method click and Enter the password of user in the password input field
     * @param password
     */
    public void clickAndEnterInPasswordAndConfirmPasswordTextField(String password, String filePath, String sheet) throws IOException{
        password += String.valueOf(random.nextInt(3000));
        driver.findElement(registerUserMap.passwordTextField()).click();
        driver.findElement(registerUserMap.passwordTextField()).sendKeys(password);
        driver.findElement(registerUserMap.confirmPasswordTextField()).click();
        driver.findElement(registerUserMap.confirmPasswordTextField()).sendKeys(password);
        excelDataProvider.writeExcel(filePath,sheet,password,7);
    }

    /**
     * This method click on the register Button
     */
    public void clickRegisterButton(){
        driver.findElement(registerUserMap.registerButton()).click();
    }

    /**
     * This method check that is Registration completed
     * @param confirmationText
     */
    public void isUserRegistrationCompleted(String confirmationText){
        String confirmationTextFromWebsite = driver.findElement(registerUserMap.confirmationOfUserRegistration()).getText();
        Assert.assertEquals(confirmationTextFromWebsite,confirmationText);
    }
}
