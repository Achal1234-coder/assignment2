package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class SignInMap {

    public By emailTextField(){
        return By.cssSelector("#Email");
    }

    public By passwordTextField(){
        return By.cssSelector("#Password");
    }

    public By loginButton(){
        return By.cssSelector(".buttons >[type=\"submit\"]");
    }
}
