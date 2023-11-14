package com.clean.pages.configuration.administratormanagement;

import org.openqa.selenium.WebDriver;

public class AdminPage {
    private AdminPage(AdminController adminController, AdminVerifier adminVerifier) {
        this.adminController = adminController;
        this.adminVerifier = adminVerifier;
    }
    public static  AdminPage adminPAge(WebDriver driver){
        return new AdminPage(new AdminController(driver),new AdminVerifier(driver));
    }

    public AdminController act() {
        return adminController;
    }

    public AdminVerifier verify() {
        return adminVerifier;
    }

    AdminController adminController;
    AdminVerifier adminVerifier;
}
