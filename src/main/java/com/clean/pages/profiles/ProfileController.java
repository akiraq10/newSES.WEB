package com.clean.pages.profiles;


import org.openqa.selenium.WebDriver;
import static com.clean.ults.ElementController.*;
import static com.clean.pages.profiles.ProfileElement.element;

public class ProfileController {
    private WebDriver driver;

    public ProfileController(WebDriver driver) {
        this.driver = driver;
    }

    public ProfileController clickOnProfile(){
        click(driver,element(driver).profiles);
        return this;
    }

    public ProfileController hoverOnProfileMenu(){
        hover(driver,element(driver).profileMenu);
        return this;
    }

    public ProfileController clickOnAddProfile(){
        click(driver,element(driver).addProfileOpt);
        return this;
    }
    public ProfileController clickOnDeleteProfile(){
        click(driver,element(driver).deleteProfileOpt);
        return this;
    }
    public ProfileController clickOnCopyProfile(){
        click(driver,element(driver).copyProfileOpt);
        return this;
    }
    public ProfileController clickOnModifyProfile(){
        click(driver,element(driver).modifyProfileOpt);
        return this;
    }
}
