package com.clean.pages.users.addfolder;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.addfolder.AddFolderElement.getAddFolderElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;


public class AddFolderController {
    private WebDriver driver;

    public AddFolderController(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Input the folder name as: {foldername}")
    public AddFolderController fillFolderName(String foldername) {
        fill(driver, getAddFolderElement(driver).folderNameTXT, foldername);
        return this;
    }

    @Step("Input the Description as: {description}")
    public AddFolderController fillDescription(String description) {
        fill(driver, getAddFolderElement(driver).descriptionTXT, description);
        return this;
    }

    @Step("Click on Save button")
    public AddFolderController clickOnSaveBtn() {
        click(driver, getAddFolderElement(driver).saveBtn);
        return this;
    }


}
