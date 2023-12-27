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
    private UserPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static UserPropertiesElements getElement(WebDriver driver){
        return new UserPropertiesElements(driver);
    }
}
