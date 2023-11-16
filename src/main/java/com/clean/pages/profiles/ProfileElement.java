package com.clean.pages.profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileElement {


    private ProfileElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static ProfileElement element(WebDriver driver){
        return new ProfileElement(driver);

    }
    @FindBy(linkText = "Profiles")
    WebElement profiles;
    @FindBy(id = "Actions_Type_Profile_Basic")
    WebElement profileMenu;
    @FindBy(id = "Actions_Type_Profile_Advanced")
    WebElement profileAdvanceMenu;
    @FindBy(id = "Actions_Profile_AddProfiles")
    WebElement addProfileOpt;
    @FindBy(id = "Actions_Profile_DeleteProfileConfirmed")
    WebElement deleteProfileOpt;
    @FindBy(id = "Actions_Profile_CopyProfile")
    WebElement copyProfileOpt;
    @FindBy(id = "Actions_Profile_ModifyProfile")
    WebElement modifyProfileOpt;
    @FindBy(id = "Actions_Profile_ImportProfile")
    WebElement importProfileOpt;
    @FindBy(id = "Actions_Profile_ExportProfile")
    WebElement exportProfileOpt;
    @FindBy(id = "breadcrumb_Profile_AddProfiles_3")
    WebElement addProfileBreadCrumb;
}
