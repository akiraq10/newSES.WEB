package com.clean.pages.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.UserElements.getUserElem;
import static com.clean.ults.ElementController.verify;



public class UserVerifier {
    private WebDriver driver ;


    public UserVerifier(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Verify the Extend icon display on the Tree Folder")
    public UserVerifier isCheckExtendIconOnFolderTree(){
        verify(driver,getUserElem(driver).expandFolderIcon);
        return this;
    }
    @Step("Verify the Users breadcrumb is displayed")
    public UserVerifier isCheckUserBreadcrumbDisplay(){
        verify(driver,getUserElem(driver).usersBreadcrumb);
        return this;
    }
    @Step("Verify The Alert Success is displayed")
    public UserVerifier isCheckAlertSuccessDisplay(){
        verify(driver,getUserElem(driver).successAlert);
        return this;
    }



}
