package com.clean.pages.users.groupproperties;

import org.openqa.selenium.WebDriver;

public class GroupPropertiesPage {
    GroupPropertiesController groupPropertiesController;
    GroupPropertiesVerifier groupPropertiesVerifier;

    private GroupPropertiesPage(GroupPropertiesController groupPropertiesController, GroupPropertiesVerifier groupPropertiesVerifier) {
        this.groupPropertiesController = groupPropertiesController;
        this.groupPropertiesVerifier = groupPropertiesVerifier;
    }

    public static GroupPropertiesPage groupPropertiesPage(WebDriver driver) {
        return new GroupPropertiesPage(new GroupPropertiesController(driver),new GroupPropertiesVerifier(driver));
    }

    public GroupPropertiesController act() {
        return groupPropertiesController;
    }

    public GroupPropertiesVerifier verify() {
        return groupPropertiesVerifier;
    }
}
