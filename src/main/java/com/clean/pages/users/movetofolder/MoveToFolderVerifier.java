package com.clean.pages.users.movetofolder;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.movetofolder.MoveToFolderElements.getElem;
import static com.clean.ults.ElementController.verify;

public class MoveToFolderVerifier {
    WebDriver driver;

    public MoveToFolderVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify The Move to Folder Page is displayed")
    public MoveToFolderVerifier isCheckMoveUserToFolderPageDisplay(){
        verify(driver,getElem(driver).moveUserToFolderBreadcrumb);
        return this;
    }
    @Step("Verify The Move to Folder Page is displayed")
    public MoveToFolderVerifier isCheckMoveGroupToFolderPageDisplay(){
        verify(driver,getElem(driver).moveGroupToFolderBreadcrumb);
        return this;
    }
    @Step("Verify the Move Button is displayed")
    public MoveToFolderVerifier isCheckMoveBtnDisplay() {
        verify(driver,getElem(driver).moveBtn);
        return this;
    }
}
