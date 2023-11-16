package com.clean.pages.configuration.administratormanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminElement {
    private AdminElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static AdminElement adminElement(WebDriver driver){
        return new AdminElement(driver);
    }

    @FindBy(id = "breadcrumb_Configuration_ViewConfigAdminUsers_3")
    WebElement administratorManagementBreadcrumb;
    @FindBy(id = "Actions_Type_Admin_Basic")
    WebElement administratorMenu;
    @FindBy(id = "Actions_Configuration_ManageRbacRoles")
    WebElement manageRoleOpt;
    @FindBy(id = "Actions_Configuration_AddAdmin")
    WebElement addNewAdminOpt;
    @FindBy(id = "Actions_Configuration_DeleteAdminConfirmed")
    WebElement deleteAdminOpt;
    @FindBy(id = "Actions_Configuration_ViewAdminGeneral")
    WebElement viewPropertiesOpt;
    @FindBy(id = "Actions_Configuration_ChangePassword")
    WebElement changeAdminPwdOpt;
    @FindBy(xpath = "//tbody")
    WebElement adminUserTable;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(xpath = "//span[@class='k-icon k-i-search']")
    WebElement searchIcon;

}
