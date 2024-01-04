package com.clean.pages.users.movetofolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoveToFolderElements {
    @FindBy(id = "breadcrumb_User_MoveUser_4")
    WebElement moveUserToFolderBreadcrumb;
    @FindBy(id = "breadcrumb_Group_MoveGroup_3")
    WebElement moveGroupToFolderBreadcrumb;
    @FindBy(id = "FF_Folders")
    WebElement folderTree;
    @FindBy(id = "btnSubmitMove")
    WebElement moveBtn;

    private MoveToFolderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    static MoveToFolderElements getElem(WebDriver driver) {
        return new MoveToFolderElements(driver);
    }
}
