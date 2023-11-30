package com.clean.pages.users.addgroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGroupElement {
    private AddGroupElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static AddGroupElement getElement(WebDriver driver) {
        return new AddGroupElement(driver);
    }

    @FindBy(id = "GroupName")
    WebElement groupName;
    @FindBy(id = "Description")
    WebElement description;
    @FindBy(name = "save")
    WebElement saveBtn;
    @FindBy(id = "GroupName-error")
    WebElement groupNameError;
//    @FindBy(xpath = "//div[@class='alert success']")
//    WebElement alertCreateGroupSuccess;

    @FindBy(css = "[class='alert success']")
    WebElement alertCreateGroupSuccess;
    @FindBy(xpath = "alert i_access_denied red")
    WebElement alertCreateGroupExisting;

}
