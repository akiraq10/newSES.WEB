package com.clean.pages.users.userproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.userproperties.UserPropertiesElements.getElement;
import static com.clean.ults.ElementController.verify;

public class UserPropertiesVerifier {
    private WebDriver driver;

    public UserPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify the User properties-> Properties: General page is displayed")
    public UserPropertiesVerifier isCheckUserPropertiesGeneralPageDisplay() {
        verify(driver,getElement(driver).userGeneralBreadcrumb);
        return this;
    }
    @Step("Check All fields are displayed in User properties -> General")
    public UserPropertiesVerifier isCheckAllFieldsDisplay(){
        verify(driver,getElement(driver).userNameTxt);
        verify(driver,getElement(driver).passwordTxt);
        verify(driver,getElement(driver).upnNameTxt);
        verify(driver,getElement(driver).samNameTxt);
        verify(driver,getElement(driver).domainTxt);
        verify(driver,getElement(driver).emailTXt);
        verify(driver,getElement(driver).descriptionTxt);
        verify(driver,getElement(driver).userMustChangePwdChk);
        verify(driver,getElement(driver).firstNameTxt);
        verify(driver,getElement(driver).lastNameTxt);
        verify(driver,getElement(driver).lastNameTxt);
        verify(driver,getElement(driver).phoneTxt);
        return this;
    }
    @Step("Verify the Success alert: {} is displayed")
    public UserPropertiesVerifier isCheckSuccessAlertDisplayed(String expect) {
        verify(driver,getElement(driver).successAlert,expect);
        return this;
    }
}
