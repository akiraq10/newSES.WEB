package com.clean.pages.profiles.addprofile;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.profiles.addprofile.AddProfileElement.addProfileElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class AddProfileController {
    private WebDriver driver;

    public AddProfileController(WebDriver driver) {
        this.driver = driver;
    }


    public AddProfileController fillProfileName(String profileName){
        fill(driver,addProfileElement(driver).profileNameTxt,profileName);
        return this;
    }

    public AddProfileController fillProfileComment(String comment){
        fill(driver,addProfileElement(driver).commentsTxt,comment);
        return this;
    }

    public AddProfileController clickOnSubmitBtn(){
        click(driver,addProfileElement(driver).submitBtn);
        return this;
    }

    public AddProfileController clickOnOkOnTheConfirmDialogBtn(){
        click(driver,addProfileElement(driver).okOnConfirmDialogBtn);
        return this;
    }
}
