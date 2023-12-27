package com.clean.pages.users.movetofolder;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.PrimitiveIterator;

import static com.clean.pages.users.movetofolder.MoveToFolderElements.getElem;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.selectElementInList;

public class MoveToFolderController {
    WebDriver driver;

    public MoveToFolderController(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select the folder: {folderName}")
    public MoveToFolderController selectFolder(String folderName) throws InterruptedException {
        selectElementInList(driver,getElem(driver).folderTree,folderName);
        return this;
    }
    @Step("Click on the Move Button")
    public MoveToFolderController clickOnMoveBtn() {
        click(driver,getElem(driver).moveBtn);
        return this;
    }
}
