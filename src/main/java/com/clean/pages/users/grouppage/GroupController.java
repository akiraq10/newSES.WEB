package com.clean.pages.users.grouppage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.grouppage.GroupElements.getEle;
import static com.clean.ults.ElementController.*;

public class GroupController {
    WebDriver driver;

     GroupController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse to Group Menu")
    public GroupController hoverToGroupMenu(){
         hover(driver,getEle(driver).groupMenu);
         return this;
    }
    @Step("Click on the Group Properties option")
    public GroupController  clickOnGroupPropertiesOpt() {
         click(driver,getEle(driver).groupPropertiesOpt);
         return this;
    }

}
