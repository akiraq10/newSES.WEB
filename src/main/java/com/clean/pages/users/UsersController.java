package com.clean.pages.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.UserElements.getUserElem;
import static com.clean.ults.ElementController.*;


public class UsersController {
    private WebDriver driver ;

    public UsersController(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Hover mouse on the Folder menu")
    public UsersController hoverOnFolderMenu() {

        hover(driver, getUserElem(driver).folderMenu);
        return this;
    }
    @Step("Click on the Add Folder option")
    public UsersController clickOnAddFolder() {
        click(driver, getUserElem(driver).addFolderOpt);
        return this;
    }
    @Step("Click on the Add User option")
    public UsersController clickOnAddUser() {
        click(driver, getUserElem(driver).addUserOpt);
        return this;
    }
    @Step("Click on the Add Group option")
    public UsersController clickOnAddGroup() {
        click(driver, getUserElem(driver).addGroupOpt);
        return this;
    }



    private UsersController clickOnExpandIcon() throws InterruptedException {
        click(driver, getUserElem(driver).expandFolderIcon);
        Thread.sleep(1000);
        return this;
    }
    @Step("Select User as {username}")
    public UsersController selectExistingUser(String username) throws InterruptedException {
        selectElementInTable(driver,getUserElem(driver).userListTbl,username);
        return this;
    }

    @Step("Select the folder as {folderName}")
    public UsersController selectFolderOnFolderTree(String folderName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserElem(driver).folderTree,folderName);
        Thread.sleep(2000);
        return this;

    }
    @Step("Click on Folder properties option")
    public UsersController clickOnFolderPropertiesOpt(){
        click(driver,getUserElem(driver).folderProperties);
        return this;
    }

    @Step("Select the folder as {groupName}")
    public UsersController selectGroupOnFolderTree(String groupName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserElem(driver).folderTree,groupName);
        Thread.sleep(2000);
        return this;

    }


}
