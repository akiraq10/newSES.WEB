package com.clean.pages.users.grouppropertiespermission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionElements {
    @FindBy(id = "RMC-DModifyPassword")
    WebElement modifyPasswordChk;
    @FindBy(id = "RMC-DModifyProfile")
    WebElement modifyProfileChk;
    @FindBy(id = "RMC-DModifyKey")
    WebElement modifyKeyChk;
    @FindBy(id = "RMC-DExportAndViewKey")
    WebElement exportAndViewKeyChk;
    @FindBy(id = "RMC-DViewTransactionLog")
    WebElement viewTransactionLogChk;
    @FindBy(id = "RMC-DSelectProfile")
    WebElement selectProfileChk;
    @FindBy(id = "RMC-DConvertRemovableMedia")
    WebElement convertRMEChk;
    @FindBy(id = "RMC-DConvertHardDisk")
    WebElement convertHardDiskChk;
    @FindBy(id = "RMC-DDiskIntegrityCheck")
    WebElement diskIntegrityChk;
    @FindBy(id = "RMC-DCreateEmergencyDisk")
    WebElement createEMGChk;
    @FindBy(id = "RMC-DConfigFfe")
    WebElement configFFEChk;
    @FindBy(id = "RMC-DExcludeDAC")
    WebElement excludeDACChk;
    @FindBy(id = "chkAllowAutoBoot")
    WebElement allowAutoBootChk;
    @FindBy(id = "rbAllow")
    WebElement allowPBNUserChk;
    @FindBy(id = "chkSaveKeyFileToClientMachine")
    WebElement saveKFLocalMachineChk;
    @FindBy(id = "rbDeny")
    WebElement denyPBNUserChk;

    @FindBy(css ="button.submit")
    WebElement saveBtn;
    @FindBy(css =".alert.success")
    WebElement alertSuccess;
    private PermissionElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static PermissionElements getElem(WebDriver driver) {
        return new PermissionElements(driver);
    }
}
