package com.assignment2.cases;

import com.assignment2.ui.pages.*;
import com.assignment2.ui.support.BaseClass;
import com.assignment2.ui.support.ExcelDataProvider;
import com.assignment2.ui.support.ReadPropertiesFileData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Properties;

public class VerifyFunctionalityOfNonCommerceWebsite extends BaseClass{

    RegisterUserPage registerUserPage = new RegisterUserPage();
    NavPage navPage = new NavPage();
    ComputersPage computersPage = new ComputersPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SignInPage signInPage = new SignInPage();
    ExcelDataProvider excelDataProvider = new ExcelDataProvider();
    CheckoutPage checkoutPage = new CheckoutPage();
    WishlistPage wishlistPage = new WishlistPage();
    ReadPropertiesFileData readPropertiesFileData = new ReadPropertiesFileData();
    Properties properties = readPropertiesFileData.fileData();

    String confirmationText = properties.getProperty("confirmationText");
    String productId1 = properties.getProperty("productId1");
    String productId19 = properties.getProperty("productId19");
    String totalProduct = properties.getProperty("totalProduct");
    String ramOfComputer = properties.getProperty("RAM");
    String billingAddressDataExcelFilePath = properties.getProperty("billingAddressDataExcel");
    String expectedConfirmationText = properties.getProperty("expectedConfirmationText");



    @DataProvider(name = "registerUserData")
    public Object[][] registerUserData() throws IOException {
        return excelDataProvider.excelDataProvider(properties.getProperty("registerUserDataExcel"),"Sheet1");
    }

    @DataProvider(name = "billingAddressData")
    public Object[][] billingAddressData ()throws IOException {
        return excelDataProvider.excelDataProvider(billingAddressDataExcelFilePath, "Sheet1");
    }

    @Test(priority = 4)
    public void verifyThatShoppingCartContainTheSameNumberOfProductThatUserPurchase(){
        computersPage.clickComputerButton();
        computersPage.clickDesktopsImage();
        computersPage.clickProductImage(productId1);
        computersPage.clickRamSelect(ramOfComputer);
        computersPage.clickHddCheckbox();
        computersPage.clickAddToCartButton(productId1);

        navPage.waitForAddCartNotification();

        electronicsPage.clickElectronicsButton();
        electronicsPage.clickCellPhonesImage();
        electronicsPage.clickProductImage(productId19);
        electronicsPage.clickAddToCartButton(productId19);

        navPage.waitForAddCartNotification();
        navPage.assertOfTotalItemsInShoppingCart(totalProduct);
    }

    @Test(dataProvider = "registerUserData",priority = 1)
    public void verifyThatUserIsAbleToRegister(String firstName, String lastName, String emailHolderName, String password) throws IOException{
        navPage.clickRegisterNavbar();

        registerUserPage.clickAndEnterFirstNameText(firstName);
        registerUserPage.clickAndEnterLastNameText(lastName);
        registerUserPage.clickAndEnterEmailTextField(emailHolderName,billingAddressDataExcelFilePath,"Sheet1");
        registerUserPage.clickAndEnterInPasswordAndConfirmPasswordTextField(password,billingAddressDataExcelFilePath,"Sheet1");
        registerUserPage.clickRegisterButton();
        registerUserPage.isUserRegistrationCompleted(confirmationText);
    }

    @Test(dataProvider = "billingAddressData",priority = 2)
    public void verifyThatUserIsAbleToConfirmOrder(String country, String state, String city, String address,
                                                   String zipCode, String phoneNo, String email, String password,
                                                   String firstName, String lastName){
        computersPage.clickComputerButton();
        computersPage.clickDesktopsImage();
        computersPage.clickProductImage(productId1);
        computersPage.clickRamSelect(ramOfComputer);
        computersPage.clickHddCheckbox();
        computersPage.clickAddToCartButton(productId1);

        electronicsPage.clickElectronicsButton();
        electronicsPage.clickCellPhonesImage();
        electronicsPage.clickProductImage(productId19);
        electronicsPage.clickAddToCartButton(productId19);

        navPage.waitForAddCartNotification();
        navPage.clickCartNotificationCloseButton();
        navPage.hoverShoppingCardNavbar();
        navPage.clickGoToCartButton();

        shoppingCartPage.clickTermOfServiceCheckbox();
        shoppingCartPage.clickCheckoutButton();

        signInPage.clickAndEnterEmailTextField(email);
        signInPage.clickAndEnterPasswordTextField(password);
        signInPage.clickLoginButton();

        shoppingCartPage.clickTermOfServiceCheckbox();
        shoppingCartPage.clickCheckoutButton();

        checkoutPage.clickAndSelectCountry(country);
        checkoutPage.clickAndSelectState(state);
        checkoutPage.clickAndEnterCityTextField(city);
        checkoutPage.clickAndEnterAddressTextField(address);
        checkoutPage.clickAndEnterZipCodeTextField(zipCode);
        checkoutPage.clickAndEnterPhoneNo(phoneNo);
        checkoutPage.clickBillingAddressContinueButton();
        checkoutPage.clickShippingMethodContinueButton();
        checkoutPage.clickPaymentMethodContinueButton();
        checkoutPage.clickPaymentInformationContinueButton();
        checkoutPage.clickConfirmButton();
        checkoutPage.assertConfirmOrder(expectedConfirmationText);
    }

    @Test(dataProvider = "billingAddressData",priority = 3)
    public void verifyThatIsUserAbleToConfirmOrderByTheWayOfWishlist(String country, String state, String city,
                                                                     String address, String zipCode, String phoneNo,
                                                                     String email, String password, String firstName,
                                                                     String lastName){
        computersPage.clickComputerButton();
        computersPage.clickDesktopsImage();
        computersPage.clickProductImage(productId1);
        computersPage.clickRamSelect(ramOfComputer);
        computersPage.clickHddCheckbox();
        computersPage.clickAddToWishlistButton(productId1);

        electronicsPage.clickElectronicsButton();
        electronicsPage.clickCellPhonesImage();
        electronicsPage.clickProductImage(productId19);
        electronicsPage.clickAddToWishlistButton(productId19);

        navPage.waitForAddCartNotification();
        navPage.clickCartNotificationCloseButton();
        navPage.clickWishListNavbar();

        wishlistPage.clickAddToCartCheckbox(productId1);
        wishlistPage.clickAddToCartButton();

        shoppingCartPage.clickTermOfServiceCheckbox();
        shoppingCartPage.clickCheckoutButton();

        signInPage.clickAndEnterEmailTextField(email);
        signInPage.clickAndEnterPasswordTextField(password);
        signInPage.clickLoginButton();

        shoppingCartPage.clickTermOfServiceCheckbox();
        shoppingCartPage.clickCheckoutButton();

        checkoutPage.clickAndSelectNewBillingAddressSelect();
        checkoutPage.clickAndEnterFirstNameTextField(firstName);
        checkoutPage.clickAndEnterLastNameTextField(lastName);
        checkoutPage.clickAndEnterEmailTextField(email);
        checkoutPage.clickAndSelectCountry(country);
        checkoutPage.clickAndSelectState(state);
        checkoutPage.clickAndEnterCityTextField(city);
        checkoutPage.clickAndEnterAddressTextField(address);
        checkoutPage.clickAndEnterZipCodeTextField(zipCode);
        checkoutPage.clickAndEnterPhoneNo(phoneNo);
        checkoutPage.clickBillingAddressContinueButton();
        checkoutPage.clickShippingMethodContinueButton();
        checkoutPage.clickPaymentMethodContinueButton();
        checkoutPage.clickPaymentInformationContinueButton();
        checkoutPage.clickConfirmButton();
        checkoutPage.assertConfirmOrder(expectedConfirmationText);
    }

    @Test(priority = 5)
    public void verifyIsUserAbleToCheckoutWithoutClickOnTermOfServiceCheckbox(){
        computersPage.clickComputerButton();
        computersPage.clickDesktopsImage();
        computersPage.clickProductImage(productId1);
        computersPage.clickRamSelect(ramOfComputer);
        computersPage.clickHddCheckbox();
        computersPage.clickAddToCartButton(productId1);

        navPage.waitForAddCartNotification();

        electronicsPage.clickElectronicsButton();
        electronicsPage.clickCellPhonesImage();
        electronicsPage.clickProductImage(productId19);
        electronicsPage.clickAddToCartButton(productId19);

        navPage.waitForAddCartNotification();
        navPage.clickCartNotificationCloseButton();
        navPage.hoverShoppingCardNavbar();
        navPage.clickGoToCartButton();

        shoppingCartPage.assertCheckoutButton();

    }
}
