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
    @FindBy(linkText = "Keys")
    WebElement keysTab;
    @FindBy(linkText = "Service Providers")
    WebElement serviceProviderTab;
    @FindBy(linkText = "Groups")
    WebElement groupsTab;
    @FindBy(id = "GroupName")
    WebElement groupNameTxt;
    @FindBy(id = "Description")
    WebElement descriptionTxt;
    @FindBy(css ="button.submit")
    WebElement saveBtn;
    @FindBy(css =".alert.success")
    WebElement alertSuccess;


    private GroupPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static GroupPropertiesElements getEle(WebDriver driver) {
        return new GroupPropertiesElements(driver);
    }
}
