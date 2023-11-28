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
    @FindBy(css = "[targetform='General']")
    WebElement installationPackageBasics;
    @FindBy(css = "[targetform='Encryption']")
    WebElement installationProcessSettings;
    @FindBy(css = "[targetform='EncryptionAdvanced']")
    WebElement deviceInfoAndKeySettings;
    @FindBy(css = "[targetform='AuthenticationRecovery']")
    WebElement deviceProvisioningAndAccess;
    @FindBy(css = "[targetform='UserRecoverySettings']")
    WebElement newUserAndRecoveryAccessSettings;
    @FindBy(css = "[targetform='Confirm']")
    WebElement confirmAndCreate;
    @FindBy(css = "[name='formRowTargetPlatform']>span")
    WebElement targetPlatformDropList;
    @FindBy(css = "[name='formRowDeviceType']>span")
    WebElement packageTypeDropList;
    @FindBy(css = "[name='formRowProfile']>span")
    WebElement profileTobeDeployDropList;
    @FindBy(name ="PackageName")
    WebElement packageNameTxt;
    @FindBy(name ="PackageDescription")
    WebElement descriptionTxt;
    @FindBy(css = "button#back")
    WebElement backBtn;
    @FindBy(css = "button#next")
    WebElement nextBtn;
    @FindBy(css = "button#submit")
    WebElement submitBtn;
    @FindBy(css = ".jconfirm-content")
    WebElement confirmationDialog;

    @FindBy(css = ".jconfirm-buttons>button")
    WebElement okOnConfirmationDialogBtn;
    @FindBy(css ="input[name='InitialPwd']")
    WebElement initialPwdTxt;







}
