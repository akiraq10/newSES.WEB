package com.clean.pages.configuration.administratormanagement.editadiminuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifyAdminUserElement {
    private ModifyAdminUserElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static ModifyAdminUserElement modifyAdminUserElement(WebDriver driver){
        return new ModifyAdminUserElement(driver);
    }

    @FindBy(id = "breadcrumb_Configuration_ViewAdminGeneral_5")
    WebElement propertiesAdminBreadcrumb;
    @FindBy(id = "Actions_Type_Admin_Basic")
    WebElement administratorMenu;
    @FindBy(id = "Actions_Configuration_AssignRbacRoleToAdmin")
    WebElement assignRoleToAdminOpt;
    @FindBy(id = "tabs_Admin_0")
    WebElement generalTab;
    @FindBy(id = "tabs_Admin_1")
    WebElement permissionTab;
    @FindBy(id = "tabs_Admin_2")
    WebElement folderTab;

}
