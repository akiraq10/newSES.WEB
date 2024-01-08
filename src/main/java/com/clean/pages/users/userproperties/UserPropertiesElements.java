package com.clean.pages.users.userproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPropertiesElements {
    @FindBy(id = "breadcrumb_User_ViewUserGeneral_4")
    WebElement userGeneralBreadcrumb;
    @FindBy(id = "Actions_Type_User_Basic")
    WebElement userMenu;
    @FindBy(id = "Actions_User_AssignGroups")
    WebElement addUserToGroupOpt;
    @FindBy(id = "User_Name")
    WebElement userNameTxt;
    @FindBy(id = "password-input")
    WebElement passwordTxt;
    @FindBy(id = "LogonNameUPN")
    WebElement upnNameTxt;
    @FindBy(id = "SAMName")
    WebElement samNameTxt;
    @FindBy(id = "DomainName")
    WebElement domainTxt;
    @FindBy(id = "Email")
    WebElement emailTXt;
    @FindBy(id = "IsAdminSetPassword")
    WebElement userMustChangePwdChk;
    @FindBy(id = "Description")
    WebElement descriptionTxt;
    @FindBy(id = "FirstName")
    WebElement firstNameTxt;
    @FindBy(id = "LastName")
    WebElement lastNameTxt;
    @FindBy(id = "Phone")
    WebElement phoneTxt;
    @FindBy(id = "edit-user-submit")
    WebElement saveBtn;
    @FindBy(css =".alert.success")
    WebElement successAlert;
    private UserPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static UserPropertiesElements getElement(WebDriver driver){
        return new UserPropertiesElements(driver);
    }
}
