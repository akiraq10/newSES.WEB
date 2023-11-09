package com.clean.pages.addgroup;


import com.clean.datatest.UserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static com.clean.ults.ElementController.*;
import static com.clean.pages.addgroup.AddGroupElement.getElement;

public class AddGroupController {
    private WebDriver driver ;

    public AddGroupController(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Input the Group name as: {groupName} ")
    public AddGroupController fillGroupName(String groupName){
        fill(driver,getElement(driver).groupName,groupName);
        return this;
    }
    @Step("Input the Group Description as: {description}")
    public AddGroupController fillDescription(String description){
        fill(driver,getElement(driver).description,description);
        return this;
    }
    @Step("Click on the Save button")
    public AddGroupController clickOnSaveButton(){
       click(driver,getElement(driver).saveBtn);
        return this;
    }

}
