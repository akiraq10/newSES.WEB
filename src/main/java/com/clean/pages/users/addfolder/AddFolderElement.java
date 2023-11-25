package com.clean.pages.users.addfolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFolderElement {
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(id = "Folder_Name")
    WebElement folderNameTXT;
    @FindBy(id = "Description")
    WebElement descriptionTXT;
//    @FindBy(xpath = "//button[contains(text(),'Save')]")
//    WebElement saveBtn;
    @FindBy(css = "[class='submit']")
    WebElement saveBtn;
//    @FindBy(xpath = "//div[@class='alert success']")
//    WebElement successAlert;
    @FindBy(css = "[class='alert success']")
    WebElement successAlert;

    private AddFolderElement(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public static AddFolderElement getAddFolderElement(WebDriver driver) {
        return new AddFolderElement(driver);
    }


}
