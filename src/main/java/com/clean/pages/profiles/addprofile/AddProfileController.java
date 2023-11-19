package com.clean.pages.profiles.addprofile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.profiles.addprofile.AddProfileElement.addProfileElement;
import static com.clean.ults.ElementController.*;

public class AddProfileController {
    private WebDriver driver;

    public AddProfileController(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input the profile name as: {profileName}")
    public AddProfileController fillProfileName(String profileName){
        fill(driver,addProfileElement(driver).profileNameTxt,profileName);
        return this;
    }
    @Step("Input the comment as: {comment}")
    public AddProfileController fillProfileComment(String comment){
        fill(driver,addProfileElement(driver).commentsTxt,comment);
        return this;
    }
    @Step("Click on Submit button ")
    public AddProfileController clickOnSubmitBtn(){
        click(driver,addProfileElement(driver).submitBtn);
        return this;
    }
    @Step("Click on OK button on the confirmation dialog")
    public AddProfileController clickOnOkOnTheConfirmDialogBtn(){
        click(driver,addProfileElement(driver).okOnConfirmDialogBtn);
        return this;
    }
    @Step("Select the target Platform as: {platform}")
    public AddProfileController selectTargetPlatform(String platform){
        selectOption(driver,addProfileElement(driver).targetPlatformDropdown,platform);
        return this;

    }
    @Step("Select the Profile type as: {profileType}")
    public AddProfileController selectProfileType(String profileType){
        selectOption(driver,addProfileElement(driver).profileTypeDropdown,profileType);
        return this;

    }
}
