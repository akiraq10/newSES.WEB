package com.clean.pages.configuration.administratormanagement.assignrole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignRoleElement {
    private AssignRoleElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static AssignRoleElement assignRoleElement(WebDriver driver){
        return new AssignRoleElement(driver);
    }

    @FindBy(id = "breadcrumb_Configuration_AssignRbacRoleToAdmin_6")
    WebElement selectRoleBreadcrumb;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(id = "Actions_Type_Admin_Basic")
    WebElement administratorMenu;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(xpath = "//tbody")
    WebElement roleListTable;
    @FindBy(name ="save")
    WebElement okBtn;
    @FindBy(xpath = "//div[@class='alert success']")
    WebElement successAlert;
}
