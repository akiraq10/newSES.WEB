package com.clean.pages.configuration.administratormanagement.addnewadmin;

import org.openqa.selenium.WebDriver;

public class AddNewAdminPage {
    AddNewAdminController addNewAdminController;
    AddNewAdminVerifier addNewAdminVerifier;
    public AddNewAdminController act() {
        return addNewAdminController;
    }

    public AddNewAdminVerifier verify() {
        return addNewAdminVerifier;
    }



    private AddNewAdminPage(AddNewAdminController addNewAdminController, AddNewAdminVerifier addNewAdminVerifier) {
        this.addNewAdminController = addNewAdminController;
        this.addNewAdminVerifier = addNewAdminVerifier;
    }
    public  static AddNewAdminPage addNewAdminPage(WebDriver driver){
        return new AddNewAdminPage(new AddNewAdminController(driver),new AddNewAdminVerifier(driver));
    }
}
