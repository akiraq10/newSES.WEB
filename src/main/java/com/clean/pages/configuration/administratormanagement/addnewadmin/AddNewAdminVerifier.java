package com.clean.pages.configuration.administratormanagement.addnewadmin;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.addnewadmin.AddNewAdminElement.addNewAdminElement;
import static com.clean.ults.ElementController.verify;

public class AddNewAdminVerifier {
    private WebDriver driver;

    public AddNewAdminVerifier(WebDriver driver) {
        this.driver = driver;
    }
    public AddNewAdminVerifier isAlertSuccessDisplay(){
        verify(driver,addNewAdminElement(driver).successAlert);
        return this;
    }
    public AddNewAdminVerifier isSelectUserPageDisplay(){
        verify(driver,addNewAdminElement(driver).selectUserBreadcrumb);
        return this;
    }
}
