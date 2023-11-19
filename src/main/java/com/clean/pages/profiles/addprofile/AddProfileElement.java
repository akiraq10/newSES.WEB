package com.clean.pages.profiles.addprofile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProfileElement {
    private AddProfileElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static AddProfileElement addProfileElement(WebDriver driver){
        return new AddProfileElement(driver);
    }

    @FindBy(xpath = "//div[@guid='General']")
    WebElement basicDetails;
    @FindBy(xpath = "//div[@guid='Encryption']")
    WebElement encryptionDisk;
    @FindBy(xpath = "//div[@guid='EncryptionAdvanced']")
    WebElement encryptionAdvanced;
    @FindBy(xpath = "//div[@guid='AuthenticationRecovery']")
    WebElement keyFileAuthentication;
    @FindBy(xpath = "//div[@guid='ClientAgentSettings']")
    WebElement clientAgentSettings;
    @FindBy(xpath = "//div[@guid='Boot']")
    WebElement deviceBoorSettings;
    @FindBy(xpath = "//div[@guid='BootTextColorSettings']")
    WebElement bootTextColorSettings;
    @FindBy(xpath = "//div[@guid='DiskAccessControl']")
    WebElement diskAccessControl;
    @FindBy(xpath = "//div[@guid='Confirm']")
    WebElement confirmAndCreate;
    @FindBy(name = "ProfileName")
    WebElement profileNameTxt;
    @FindBy(name ="Comments")
    WebElement commentsTxt;
    @FindBy(id = "back")
    WebElement backBtn;
    @FindBy(id = "next")
    WebElement nextBtn;
    @FindBy(id = "submit")
    WebElement submitBtn;
    @FindBy(xpath = "//div[@class='jconfirm-content']")
    WebElement confirmDialog;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okOnConfirmDialogBtn;
    @FindBy(xpath = "//div[@name='formRowTargetPlatform']/span")
    WebElement targetPlatformDropdown;
    @FindBy(xpath = "//div[@name='formRowDeviceType']/span")
    WebElement profileTypeDropdown;



}
