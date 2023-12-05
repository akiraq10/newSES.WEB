package com.clean.pages.users.assignKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignKeyElement {
    @FindBy(id = "breadcrumb_Folder_AssignKey_4")
    WebElement assignKeyBreadcrumb;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(css ="[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(css ="table[data-role='selectable']")
    WebElement selectKeyTable;
    @FindBy(css ="button.submit")
    WebElement saveBtn;
    @FindBy(linkText = "Display all keys")
    WebElement displayAllKeysChk;

    @FindBy(css ="div.alert.warning")
    WebElement alertWarning;
    @FindBy(css ="div.alert.success")
    WebElement alertSuccess;
    private AssignKeyElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    static AssignKeyElement getAssignElement(WebDriver driver) {
        return new AssignKeyElement(driver);
    }
}
