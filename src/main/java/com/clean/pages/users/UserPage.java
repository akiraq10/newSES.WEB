package com.clean.pages.users;

import org.openqa.selenium.WebDriver;

public class UserPage {

    UsersController usersController;
    UserVerifier userVerifier;

    private UserPage(UsersController usersController, UserVerifier userVerifier) {
        this.usersController = usersController;
        this.userVerifier = userVerifier;

    }

    public static UserPage userPage(WebDriver driver) {
        return new UserPage(new UsersController(driver), new UserVerifier(driver));
    }

    public UsersController act() {
        return usersController;
    }

    public UserVerifier verify() {
        return userVerifier;
    }

}
