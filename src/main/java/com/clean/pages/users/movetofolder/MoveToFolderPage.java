package com.clean.pages.users.movetofolder;

import org.openqa.selenium.WebDriver;

public class MoveToFolderPage {
    MoveToFolderController moveToFolderController;
    MoveToFolderVerifier moveToFolderVerifier;

    private MoveToFolderPage(MoveToFolderController moveToFolderController, MoveToFolderVerifier moveToFolderVerifier) {
        this.moveToFolderController = moveToFolderController;
        this.moveToFolderVerifier = moveToFolderVerifier;
    }
    public static MoveToFolderPage moveToFolderPage(WebDriver driver){
        return new MoveToFolderPage(new MoveToFolderController(driver),new MoveToFolderVerifier(driver));
    }

    public MoveToFolderController act() {
        return moveToFolderController;
    }

    public MoveToFolderVerifier verify() {
        return moveToFolderVerifier;
    }
}
