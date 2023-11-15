package com.clean.pages.users.addgroup;



import org.openqa.selenium.WebDriver;
import static com.clean.ults.ElementController.*;
import static com.clean.pages.users.addgroup.AddGroupElement.getElement;

public class AddGroupController {
    private WebDriver driver ;

    public AddGroupController(WebDriver driver) {
        this.driver=driver;

    }

    public AddGroupController fillGroupName(String groupName){
        fill(driver,getElement(driver).groupName,groupName);
        return this;
    }

    public AddGroupController fillDescription(String description){
        fill(driver,getElement(driver).description,description);
        return this;
    }

    public AddGroupController clickOnSaveButton(){
       click(driver,getElement(driver).saveBtn);
        return this;
    }

}
