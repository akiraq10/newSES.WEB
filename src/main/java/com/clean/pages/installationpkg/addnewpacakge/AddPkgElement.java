package com.clean.pages.installationpkg.addnewpacakge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPkgElement {
    private AddPkgElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static AddPkgElement addPkgElement(WebDriver driver)
    {
        return new AddPkgElement(driver);
    }

    @FindBy(id = "breadcrumb_Package_AddPackages_3")
    WebElement addInstallationPackageBreadcrumb;
    @FindBy(xpath = "//div[@targetform='General']")
    WebElement installationPackageBasics;
    @FindBy(xpath = "//div[@targetform='Encryption']")
    WebElement installationProcessSettings;
    @FindBy(xpath = "//div[@targetform='EncryptionAdvanced']")
    WebElement deviceInfoAndKeySettings;
    @FindBy(xpath = "//div[@targetform='AuthenticationRecovery']")
    WebElement deviceProvisioningAndAccess;
    @FindBy(xpath = "//div[@targetform='UserRecoverySettings']")
    WebElement newUserAndRecoveryAccessSettings;
    @FindBy(xpath = "//div[@targetform='Confirm']")
    WebElement confirmAndCreate;
    @FindBy(xpath = "//div[@name='formRowTargetPlatform']/span")
    WebElement targetPlatformDropList;
    @FindBy(xpath = "//div[@name='formRowDeviceType']/span")
    WebElement packageTypeDropList;
    @FindBy(xpath = "//div[@name='formRowProfile']/span")
    WebElement profileTobeDeployDropList;
    @FindBy(name ="PackageName")
    WebElement packageNameTxt;
    @FindBy(name ="PackageDescription")
    WebElement descriptionTxt;
    @FindBy(xpath = "//button[@id='back']")
    WebElement backBtn;
    @FindBy(xpath = "//button[@id='next']")
    WebElement nextBtn;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//div[@class='jconfirm-content']")
    WebElement confirmationDialog;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okOnConfirmationDialogBtn;







}
