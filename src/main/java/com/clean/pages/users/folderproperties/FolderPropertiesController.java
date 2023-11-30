package com.clean.pages.users.folderproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.folderproperties.FolderPropertiesElements.getFolderElement;
import static com.clean.ults.ElementController.*;

public class FolderPropertiesController {
    private WebDriver driver;

    public FolderPropertiesController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse on General menu")
    public FolderPropertiesController hoverOnGeneralMenu(){
        hover(driver,getFolderElement(driver).generalMEnu);
        return this;
    }
    @Step("Hover mouse on Folder menu")
    public FolderPropertiesController hoverOnFolderMenu(){
        hover(driver,getFolderElement(driver).folderMenu);
        return this;
    }
    @Step("Click on Back option")
    public FolderPropertiesController clickOnBackOption(){
        click(driver,getFolderElement(driver).backOpt);
        return this;
    }

}
