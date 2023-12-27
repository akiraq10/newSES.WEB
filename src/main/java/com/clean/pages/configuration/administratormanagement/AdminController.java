package com.clean.pages.configuration.administratormanagement;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.AdminElement.adminElement;
import static com.clean.ults.ElementController.*;

public class AdminController {
    private WebDriver driver;

    public AdminController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse on the Administrator menu")
    public AdminController hoverOnAdministratorMenu(){
        hover(driver,adminElement(driver).administratorMenu);
        return this;
    }
    @Step("Click on the Add new Administrator option")
    public AdminController clickOnAddNewAdminOpt(){
        click(driver,adminElement(driver).addNewAdminOpt);
        return this;
    }
    @Step("Click on the View Properties option")
    public AdminController clickOnViewPropertiesOpt(){
        click(driver,adminElement(driver).viewPropertiesOpt);
        return this;
    }
    @Step("Select an admin user :{username}")
    public AdminController selectAdminUser(String username) throws InterruptedException {
        selectElementHasLinkInTable(driver,adminElement(driver).adminUserTable,username);
        return this;
    }
}
