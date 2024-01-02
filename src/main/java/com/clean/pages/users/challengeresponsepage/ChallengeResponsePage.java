package com.clean.pages.users.challengeresponsepage;

import org.openqa.selenium.WebDriver;

public class ChallengeResponsePage {
    ChallengeResponseController challengeResponseController;
    ChallengeResponseVerifier challengeResponseVerifier;

    private ChallengeResponsePage(ChallengeResponseController challengeResponseController, ChallengeResponseVerifier challengeResponseVerifier) {
        this.challengeResponseController = challengeResponseController;
        this.challengeResponseVerifier = challengeResponseVerifier;
    }
    public static ChallengeResponsePage challengeResponsePage(WebDriver driver){
        return new ChallengeResponsePage(new ChallengeResponseController(driver),new ChallengeResponseVerifier(driver));
    }

    public ChallengeResponseController act() {
        return challengeResponseController;
    }

    public ChallengeResponseVerifier verify() {
        return challengeResponseVerifier;
    }
}
