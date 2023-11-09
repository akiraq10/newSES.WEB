package com.clean.pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserElements {

    @FindBy(linkText = "Users")
    WebElement usersPage;
    @FindBy(id = "Actions_Type_User_Basic")
    WebElement userMenu;
    @FindBy(id = "Actions_Type_User_Advanced")
    WebElement userAdvancedMenu;
    @FindBy(id = "Actions_Type_Folder_Basic")
    WebElement folderMenu;
    @FindBy(id = "Actions_Folder_AddFolder")
    WebElement addFolderOpt;
    @FindBy(id = "Actions_Folder_AddUserGeneral")
    WebElement addUserOpt;
    @FindBy(id = "Actions_Group_AddGroup")
    WebElement addGroupOpt;
    @FindBy(id = "Actions_User_ChallengeResponseGen")
    WebElement challengeResponseRMCEOpt;
    @FindBy(xpath = "//*[@id='UF_0_Rm9sZGVycw==']/ins")
    WebElement expandFolderIcon;
    private UserElements(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    public static UserElements getUserElem(WebDriver driver) {
        return new UserElements(driver);
    }


}