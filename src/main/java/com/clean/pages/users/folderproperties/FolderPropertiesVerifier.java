package com.clean.pages.users.folderproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.folderproperties.FolderPropertiesElements.getFolderElement;
import static com.clean.ults.ElementController.verify;

public class FolderPropertiesVerifier {
    private WebDriver driver;

    public FolderPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the folder breadcrumb is display")
    public FolderPropertiesVerifier isCheckFolderPropertiesBreadcrumbDisplay(){
        verify(driver,getFolderElement(driver).folderPropertiesBreadcrumb);
        return this;
    }

}
