package com.clean.pages.configuration.administratormanagement;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.AdminElement.adminElement;
import static com.clean.ults.ElementController.*;

public class AdminController {
    private WebDriver driver;

    public AdminController(WebDriver driver) {
        this.driver = driver;
    }

    public AdminController hoverOnAdministratorMenu(){
        hover(driver,adminElement(driver).administratorMenu);
        return this;
    }

    public AdminController clickOnAddNewAdminOpt(){
        click(driver,adminElement(driver).addNewAdminOpt);
        return this;
    }

    public AdminController clickOnViewPropertiesOpt(){
        click(driver,adminElement(driver).viewPropertiesOpt);
        return this;
    }

    public AdminController selectAdminUser(String username) throws InterruptedException {
        selectElementInTable(driver,adminElement(driver).adminUserTable,username);
        return this;
    }
}
