package com.clean.pages.users.grouppropertiespermission;

import org.openqa.selenium.WebDriver;

public class PermissionPage {
    PermissionController permissionController;
    PermissionVerifier permissionVerifier;

    private PermissionPage(PermissionController permissionController, PermissionVerifier permissionVerifier) {
        this.permissionController = permissionController;
        this.permissionVerifier = permissionVerifier;
    }

    public static PermissionPage permissionPage(WebDriver driver) {
        return new PermissionPage(new PermissionController(driver),new PermissionVerifier(driver));
    }

    public PermissionController act() {
        return permissionController;
    }

    public PermissionVerifier verify() {
        return permissionVerifier;
    }
}
