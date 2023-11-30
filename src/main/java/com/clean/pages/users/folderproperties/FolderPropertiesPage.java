package com.clean.pages.users.folderproperties;

import org.openqa.selenium.WebDriver;

public class FolderPropertiesPage {
    FolderPropertiesController folderPropertiesController;
    FolderPropertiesVerifier folderPropertiesVerifier;

    private FolderPropertiesPage(FolderPropertiesController folderPropertiesController, FolderPropertiesVerifier folderPropertiesVerifier) {
        this.folderPropertiesController = folderPropertiesController;
        this.folderPropertiesVerifier = folderPropertiesVerifier;
    }
    public static FolderPropertiesPage folderPropertiesPage(WebDriver driver){
        return new FolderPropertiesPage(new FolderPropertiesController(driver),new FolderPropertiesVerifier(driver));
    }

    public FolderPropertiesController act() {
        return folderPropertiesController;
    }

    public FolderPropertiesVerifier verify() {
        return folderPropertiesVerifier;
    }
}
