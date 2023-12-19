package com.clean.pages.users.grouppropertiespermission;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.grouppropertiespermission.PermissionElements.getElem;
import static com.clean.ults.ElementController.click;

public class PermissionController {
    WebDriver driver;

    PermissionController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click On the Modify Password privilege")
    public PermissionController clickOnModifyPwd() {
        click(driver,getElem(driver).modifyPasswordChk);
        return this;
    }
    @Step("Click On the Modify Profile privilege")
    public PermissionController clickOnModifyProfile() {
        click(driver,getElem(driver).modifyProfileChk);
        return this;
    }
    @Step("Click On the Modify Key privilege")
    public PermissionController clickOnModifyKey() {
        click(driver,getElem(driver).modifyKeyChk);
        return this;
    }
    @Step("Click On the Export and view key privilege")
    public PermissionController clickOnExportAndViewKey() {
        click(driver,getElem(driver).exportAndViewKeyChk);
        return this;
    }
    @Step("Click On the View transaction log privilege")
    public PermissionController clickOnViewTranLog() {
        click(driver,getElem(driver).viewTransactionLogChk);
        return this;
    }
    @Step("Click On the Select profile privilege")
    public PermissionController clickOnSelectProfile() {
        click(driver,getElem(driver).selectProfileChk);
        return this;
    }
    @Step("Click On the Convert removable media privilege")
    public PermissionController clickOnConvertRME() {
        click(driver,getElem(driver).convertRMEChk);
        return this;
    }
    @Step("Click On the Convert hard disk privilege")
    public PermissionController clickOnConvertHardDisk() {
        click(driver,getElem(driver).convertHardDiskChk);
        return this;
    }
    @Step("Click On the Disk integrity check privilege")
    public PermissionController clickOnDiskIntegrity() {
        click(driver,getElem(driver).diskIntegrityChk);
        return this;
    }
    @Step("Click On the Create emergency disk privilege")
    public PermissionController clickOnCreateEMG() {
        click(driver,getElem(driver).createEMGChk);
        return this;
    }
    @Step("Click On the Config SFE privilege")
    public PermissionController clickOnConfigFFE() {
        click(driver,getElem(driver).configFFEChk);
        return this;
    }
    @Step("Click On the Exclude from DAC (password sync should be enabled) privilege")
    public PermissionController clickOnExcludeFromDAC() {
        click(driver,getElem(driver).excludeDACChk);
        return this;
    }
    @Step("Click On the Allow auto-boot via PBConnex privilege")
    public PermissionController clickOnAllowPBNAutoBoot() {
        click(driver,getElem(driver).allowAutoBootChk);
        return this;
    }
    @Step("Click On the Get keyfile via PBConne-> Allow privilege")
    public PermissionController clickOnAllowPBNUser() {
        click(driver,getElem(driver).allowPBNUserChk);
        return this;
    }
    @Step("Click On the Get keyfile via PBConne-> Deny privilege")
    public PermissionController clickOnDenyPBNUser() {
        click(driver,getElem(driver).denyPBNUserChk);
        return this;
    }
    @Step("Click On the Save button")
    public PermissionController clickOnSaveBtn() {
        click(driver,getElem(driver).saveBtn);
        return this;
    }


}
