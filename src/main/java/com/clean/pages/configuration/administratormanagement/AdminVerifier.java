package com.clean.pages.configuration.administratormanagement;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.AdminElement.adminElement;
import static com.clean.ults.ElementController.verify;

public class AdminVerifier {
    private WebDriver driver;

    public AdminVerifier(WebDriver driver) {
        this.driver = driver;
    }
    public AdminVerifier isAdministratorPageDisplay(){
        verify(driver,adminElement(driver).administratorManagementBreadcrumb);
        return this;
    }
}
