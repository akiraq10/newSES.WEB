package com.clean.pages.users.checkpbconnexpage;

import org.openqa.selenium.WebDriver;

public class CheckPBConnexPage {
    CheckPBConnexControler checkPBConnexControler;
    CheckPBConnexVerifier checkPBConnexVerifier;

    private CheckPBConnexPage(CheckPBConnexControler checkPBConnexControler, CheckPBConnexVerifier checkPBConnexVerifier) {
        this.checkPBConnexControler = checkPBConnexControler;
        this.checkPBConnexVerifier = checkPBConnexVerifier;
    }

    public CheckPBConnexControler act() {
        return checkPBConnexControler;
    }

    public CheckPBConnexVerifier verify() {
        return checkPBConnexVerifier;
    }
    public static CheckPBConnexPage checkPBConnexPage(WebDriver driver){
        return new CheckPBConnexPage(new CheckPBConnexControler(driver),new CheckPBConnexVerifier(driver));
    }
}
