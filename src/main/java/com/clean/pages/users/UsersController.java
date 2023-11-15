package com.clean.pages.users;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.UserElements.getUserElem;
import static com.clean.ults.ElementController.*;


public class UsersController {
    private WebDriver driver ;

    public UsersController(WebDriver driver) {
        this.driver=driver;

    }


    public UsersController hoverOnFolderMenu() {

        hover(driver, getUserElem(driver).folderMenu);
        return this;
    }

    public UsersController clickOnAddFolder() {
        click(driver, getUserElem(driver).addFolderOpt);
        return this;
    }

    public UsersController clickOnAddUser() {
        click(driver, getUserElem(driver).addUserOpt);
        return this;
    }

    public UsersController clickOnAddGroup() {
        click(driver, getUserElem(driver).addGroupOpt);
        return this;
    }


    public UsersController clickOnExpandIcon() throws InterruptedException {
        Thread.sleep(1000);
        click(driver, getUserElem(driver).expandFolderIcon);
        return this;
    }

    public UsersController selectExistingUser(String username) throws InterruptedException {
        selectElementInTable(driver,getUserElem(driver).userListTbl,username);
        return this;
    }


}
