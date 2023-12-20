package com.clean.pages.users.groupproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupPropertiesElements {
    @FindBy(id = "breadcrumb_Group_ViewGroupGeneral_4")
    WebElement groupPropertiesGeneralBreadcrumb;
    @FindBy(id = "breadcrumb_Group_ViewGroupSecurity_4")
    WebElement groupPropertiesPermissionBreadcrumb;
    @FindBy(id = "breadcrumb_Group_ViewGroupKeys_4")
    WebElement groupPropertiesKeysBreadcrumb;
    @FindBy(id = "breadcrumb_Group_ViewGroupServiceProviders_4")
    WebElement groupPropertiesServiceProviderBreadcrumb;
    @FindBy(id = "breadcrumb_Group_ViewGroupParentGroups_4")
    WebElement groupPropertiesGroupsBreadcrumb;


    @FindBy(linkText = "General")
    WebElement generalTab;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(linkText = "Permissions")
    WebElement permissionsTab;
    @FindBy(xpath = "//li/a[text()='Keys']")
    WebElement keysTab;
    @FindBy(linkText = "Service Providers")
    WebElement serviceProviderTab;
    @FindBy(xpath = "//*[@class='options-nav-header']//a[text()='Groups']")
    WebElement groupsTab;
    @FindBy(id = "GroupName")
    WebElement groupNameTxt;
    @FindBy(id = "Description")
    WebElement descriptionTxt;
    @FindBy(css ="button.submit")
    WebElement saveBtn;
    @FindBy(css =".alert.success")
    WebElement alertSuccess;
    @FindBy(id = "Actions_Type_Group_Basic")
    WebElement groupMenu;
    @FindBy(id = "Actions_Group_AssignKey")
    WebElement assignKeyOpt;
    @FindBy(id = "Actions_Group_RemoveKey")
    WebElement removeKeyOpt;
    @FindBy(css ="table[data-role='selectable']")
    WebElement selectTable;
    @FindBy(id = "Actions_Group_AssignParentGroup")
    WebElement assignGroupOpt;
    @FindBy(id = "Actions_Group_RemoveParentGroup")
    WebElement removeGroupOpt;
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesOnConfirmationDialogBtn;
    @FindBy(xpath = "//button[text()='No']")
    WebElement noOnConfirmationDialogBtn;
    @FindBy(id = "Actions_Group_AssignServiceProviders")
    WebElement assignServiceProviderOpt;
    @FindBy(id = "Actions_Group_RemoveServiceProviders")
    WebElement removeServiceProviderOpt;
    @FindBy(id = "AllowOob")
    WebElement allowOOBChk;



    private GroupPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static GroupPropertiesElements getEle(WebDriver driver) {
        return new GroupPropertiesElements(driver);
    }
}
