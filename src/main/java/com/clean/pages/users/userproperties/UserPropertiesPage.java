package com.clean.pages.users.userproperties;

import org.openqa.selenium.WebDriver;

public class UserPropertiesPage {
    UserPropertiesController userPropertiesController;
    UserPropertiesVerifier userPropertiesVerifier;

    private UserPropertiesPage(UserPropertiesController userPropertiesController, UserPropertiesVerifier userPropertiesVerifier) {
        this.userPropertiesController = userPropertiesController;
        this.userPropertiesVerifier = userPropertiesVerifier;
    }

    public static UserPropertiesPage userPropertiesPage(WebDriver driver) {
        return new UserPropertiesPage(new UserPropertiesController( driver),new UserPropertiesVerifier(driver));
    }

    public UserPropertiesController act() {
        return userPropertiesController;
    }

    public UserPropertiesVerifier verify() {
        return userPropertiesVerifier;
    }
}
