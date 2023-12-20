package com.clean.pages.users.assignserviceprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignSPElements {
    @FindBy(id = "breadcrumb_Group_AssignServiceProviders_5")
    WebElement assignSPBreadcrumb;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(css ="table[data-role='selectable']")
    WebElement selectSPTable;
    @FindBy(css ="button[name='save']")
    WebElement saveBtn;
    private AssignSPElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static AssignSPElements getElem(WebDriver driver) {
        return new AssignSPElements(driver);
    }
}
