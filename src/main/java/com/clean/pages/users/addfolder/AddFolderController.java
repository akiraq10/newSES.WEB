package com.clean.pages.users.addfolder;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.addfolder.AddFolderElement.getAddFolderElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;


public class AddFolderController {
    private WebDriver driver;

    public AddFolderController(WebDriver driver) {
        this.driver = driver;

    }


    public AddFolderController fillFolderName(String foldername) {
        fill(driver, getAddFolderElement(driver).folderNameTXT, foldername);
        return this;
    }


    public AddFolderController fillDescription(String description) {
        fill(driver, getAddFolderElement(driver).descriptionTXT, description);
        return this;
    }


    public AddFolderController clickOnSaveBtn() {
        click(driver, getAddFolderElement(driver).saveBtn);
        return this;
    }


}
