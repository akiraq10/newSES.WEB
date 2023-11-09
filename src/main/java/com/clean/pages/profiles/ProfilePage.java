package com.clean.pages.profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;

public class ProfilePage {
    ProfileController profileController;
    ProfileVerifier profileVerifier;

    private ProfilePage(ProfileController profileController, ProfileVerifier profileVerifier) {
        this.profileController = profileController;
        this.profileVerifier = profileVerifier;
    }
    public static ProfilePage profilePage(WebDriver driver){
        return new ProfilePage(new ProfileController(driver),new ProfileVerifier(driver));
    }

    public ProfileController act() {
        return profileController;
    }

    public ProfileVerifier verify() {
        return profileVerifier;
    }
}
