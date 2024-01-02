package com.clean.pages.users.checkpbconnexpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckPBConnexElement {
    @FindBy(id = "breadcrumb_User_CheckPBConnex_4")
    WebElement checkPBConnexBreadcrumb;
    @FindBy(id = "Actions_Type_General")
    WebElement generalMenu;

    private CheckPBConnexElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

     static CheckPBConnexElement getEle(WebDriver driver) {
        return new CheckPBConnexElement(driver);
    }
}
