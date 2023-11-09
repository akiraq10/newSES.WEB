package com.clean.pages.adduser;

import com.clean.pages.idpInstallation.IdPInstallationController;
import com.clean.pages.idpInstallation.IdPInstallationPage;
import com.clean.pages.idpInstallation.IdPInstallationVerifier;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    AddUserController addUserController;
    AddUserVerifier addUserVerifier;
    private AddUserPage(AddUserController addUserController, AddUserVerifier addUserVerifier) {
        this.addUserController = addUserController;
        this.addUserVerifier = addUserVerifier;

    }

    public static AddUserPage addUserPage(WebDriver driver) {
        return new AddUserPage(new AddUserController(driver), new AddUserVerifier(driver));
    }

    public AddUserController act() {
        return addUserController;
    }

    public AddUserVerifier verify() {
        return addUserVerifier;
    }
}
