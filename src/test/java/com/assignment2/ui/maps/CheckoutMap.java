package com.assignment2.ui.maps;

import org.openqa.selenium.By;

public class CheckoutMap {

    public By firstNameTextField(){
        return By.cssSelector("#BillingNewAddress_FirstName");
    }

    public By lastNameTextField(){
        return By.cssSelector("#BillingNewAddress_LastName");
    }

    public By emailTextField(){
        return By.cssSelector("#BillingNewAddress_Email");
    }

    public By loadingWaitIcon(){
        return By.cssSelector("span#states-loading-progress");
    }

    public By countrySelectField(){
        return By.cssSelector("#BillingNewAddress_CountryId");
    }

    public By stateSelectField(){
        return By.cssSelector("select#BillingNewAddress_StateProvinceId");
    }

    public By cityTextField(){
        return By.cssSelector("#BillingNewAddress_City");
    }

    public By addressTextField(){
        return  By.cssSelector("#BillingNewAddress_Address1");
    }

    public By zipCodeTextField(){
        return By.cssSelector("#BillingNewAddress_ZipPostalCode");
    }

    public By phoneNoTextField(){
        return By.cssSelector("#BillingNewAddress_PhoneNumber");
    }

    public By billingAddressContinueButton(){
        return By.cssSelector("#billing-buttons-container > .new-address-next-step-button");
    }

    public By shippingMethodContinueButton(){
        return By.cssSelector(".shipping-method-next-step-button");
    }

    public By paymentMethodContinueButton(){
        return By.cssSelector(".payment-method-next-step-button");
    }

    public By paymentInformationContinueButton(){
        return By.cssSelector(".payment-info-next-step-button");
    }

    public By confirmButton(){
        return By.cssSelector(".confirm-order-next-step-button");
    }

    public By orderConfirmationText(){
        return By.cssSelector(".order-completed > div > strong");
    }

    public By newBillingAddressSelect(){
        return By.cssSelector("select#billing-address-select");
    }
}
