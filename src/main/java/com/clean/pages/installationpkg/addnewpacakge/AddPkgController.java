package com.clean.pages.installationpkg.addnewpacakge;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.addnewpacakge.AddPkgElement.addPkgElement;
import static com.clean.ults.ElementController.*;

public class AddPkgController {
    private WebDriver driver;

    public AddPkgController(WebDriver driver) {
        this.driver = driver;
    }


  public AddPkgController selectProfileName(String profileName){
        selectOption(driver,addPkgElement(driver).profileTobeDeployDropList,profileName);
        return this;

  }

  public AddPkgController fillDescription(String description){
        fill(driver,addPkgElement(driver).descriptionTxt,description);
        return this;

  }

  public AddPkgController clickOnSubmitBtn(){
        click(driver,addPkgElement(driver).submitBtn);
        return this;
  }

  public AddPkgController clickOnOkBtnOnConfirmationDialog(){
        click(driver,addPkgElement(driver).okOnConfirmationDialogBtn);
        return this;

  }
}
