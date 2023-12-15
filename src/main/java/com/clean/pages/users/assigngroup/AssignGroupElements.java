package com.clean.pages.users.assigngroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignGroupElements {
    @FindBy(id = "breadcrumb_Folder_AssignGroup_4")
    WebElement assignGroupBreadcrumb;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(css ="table[data-role]>tbody")
    WebElement selectUserTable;
    @FindBy(linkText = "Display all groups")
    WebElement displayAllGroupsChk;
    @FindBy(css ="button[name='save']")
    WebElement saveBtn;
    @FindBy(css =".alert.warning")
    WebElement redWarningAlert;

    private AssignGroupElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    static AssignGroupElements getEle(WebDriver driver){
        return new AssignGroupElements(driver);
    }
}
