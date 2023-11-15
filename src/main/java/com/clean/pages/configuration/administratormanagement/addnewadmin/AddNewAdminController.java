package com.clean.pages.configuration.administratormanagement.addnewadmin;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.addnewadmin.AddNewAdminElement.addNewAdminElement;
import static com.clean.ults.ElementController.*;

public class AddNewAdminController {
    private WebDriver driver;

    public AddNewAdminController(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewAdminController searchAdminUser(String username){
        fill(driver,addNewAdminElement(driver).searchTxt,username);
        return this;
    }

    public AddNewAdminController selectAdminUser(String username) throws InterruptedException {
        selectElementInTable(driver,addNewAdminElement(driver).adminUserTable,username);
        return this;
    }

    public AddNewAdminController clickOnSaveButton(){
        click(driver,addNewAdminElement(driver).saveBtn);
        return this;
    }
}
