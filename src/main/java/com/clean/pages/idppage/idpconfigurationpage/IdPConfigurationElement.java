package com.clean.pages.idppage.idpconfigurationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class IdPConfigurationElement {
    private IdPConfigurationElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static IdPConfigurationElement idPConfigurationElement(WebDriver driver){
        return new IdPConfigurationElement(driver);
    }
    @FindBy(linkText ="Configuration")
    WebElement configurationMenu;
    @FindBy(linkText = "SAML SPs")
    WebElement samlSPTab;
    @FindBy(linkText = "OIDC")
    WebElement oidcTab;
    @FindBy(linkText = "RADIUS")
    WebElement radiusTab;
    @FindBy(linkText = "LDAP")
    WebElement ldapTab;
    @FindBy(linkText = "Global")
    WebElement globalTab;
    @FindBy(linkText = "FIDO Security Keys")
    WebElement fidoKeyTab;
    @FindBy(linkText = "Mobile")
    WebElement mobileTab;

}
