package com.clean.pages.profiles;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static com.clean.ults.ElementController.*;
import static com.clean.pages.profiles.ProfileElement.element;

public class ProfileController {
    private WebDriver driver;

    public ProfileController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the Profile page")
    public ProfileController clickOnProfile(){
        click(driver,element(driver).profiles);
        return this;
    }
    @Step("Hover mouse to the Profile menu")
    public ProfileController hoverOnProfileMenu(){
        hover(driver,element(driver).profileMenu);
        return this;
    }
    @Step("Click on the Add Profile Option")
    public ProfileController clickOnAddProfile(){
        click(driver,element(driver).addProfileOpt);
        return this;
    }@Step("Click on the Delete Profile Option")
    public ProfileController clickOnDeleteProfile(){
        click(driver,element(driver).deleteProfileOpt);
        return this;
    }@Step("Click on the Copy Profile Option")
    public ProfileController clickOnCopyProfile(){
        click(driver,element(driver).copyProfileOpt);
        return this;
    }@Step("Click on the Modify Profile Option")
    public ProfileController clickOnModifyProfile(){
        click(driver,element(driver).modifyProfileOpt);
        return this;
    }
}
