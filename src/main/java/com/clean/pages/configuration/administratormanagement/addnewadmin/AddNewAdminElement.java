package com.clean.pages.configuration.administratormanagement.addnewadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAdminElement {
    private AddNewAdminElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static AddNewAdminElement addNewAdminElement(WebDriver driver){
        return new AddNewAdminElement(driver);
    }

    @FindBy(id = "breadcrumb_Configuration_AddAdmin_4")
    WebElement selectUserBreadcrumb;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(xpath = "//tbody")
    WebElement adminUserTable;
    @FindBy(name ="save")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@class='alert success']")
    WebElement successAlert;
}
