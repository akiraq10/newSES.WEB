package com.clean.pages.installationpkg.addnewpacakge;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.addnewpacakge.AddPkgElement.addPkgElement;
import static com.clean.ults.ElementController.*;

public class AddPkgController {
    private WebDriver driver;

    public AddPkgController(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select the Profile name")
  public AddPkgController selectProfileName(String profileName){
        selectOption(driver,addPkgElement(driver).profileTobeDeployDropList,profileName);
        return this;

  }
  @Step("Input the Description as: {description}")
  public AddPkgController fillDescription(String description){
        fill(driver,addPkgElement(driver).descriptionTxt,description);
        return this;

  }
  @Step("Click on the Submit button")
  public AddPkgController clickOnSubmitBtn(){
        click(driver,addPkgElement(driver).submitBtn);
        return this;
  }
    @Step("Click on the Ok button on the Confirmation dialog ")
  public AddPkgController clickOnOkBtnOnConfirmationDialog(){
        click(driver,addPkgElement(driver).okOnConfirmationDialogBtn);
        return this;

  }
}
