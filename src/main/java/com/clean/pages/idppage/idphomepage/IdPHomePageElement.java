package com.clean.pages.idppage.idphomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdPHomePageElement {
    private IdPHomePageElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static IdPHomePageElement idPHomePageElement(WebDriver driver)
    {
        return new IdPHomePageElement(driver);
    }

    @FindBy(linkText = "Home")
    WebElement homeMenu;
    @FindBy(xpath = "//h1[contains(text(),'Online users')]")
    WebElement onlineUserText;
}
