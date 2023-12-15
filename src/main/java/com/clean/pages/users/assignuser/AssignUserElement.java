package com.clean.pages.users.assignuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v117.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignUserElement {
    @FindBy(id = "breadcrumb_Folder_AssignUser_4")
    WebElement assignUserBreadcrumb;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(css ="table[data-role]>tbody")
    WebElement selectUserTable;
    @FindBy(linkText = "Display all users")
    WebElement displayAllUsersOpt;
    @FindBy(css ="button[name='save']")
    WebElement saveBtn;
    @FindBy(css =".alert.warning")
    WebElement redWaringAlert;
    private AssignUserElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static AssignUserElement getAssignUserEle(WebDriver driver) {
        return new AssignUserElement(driver);
    }
}
