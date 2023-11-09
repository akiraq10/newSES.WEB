package com.clean.pages.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.UserElements.getUserElem;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.hover;


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


    public UsersController clickOnExpandIcon() throws InterruptedException {
        Thread.sleep(1000);
        click(driver, getUserElem(driver).expandFolderIcon);
        return this;
    }


}
