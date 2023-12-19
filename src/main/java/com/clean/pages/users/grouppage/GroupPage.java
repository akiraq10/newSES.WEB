package com.clean.pages.users.grouppage;

import org.openqa.selenium.WebDriver;

public class GroupPage {
    GroupController groupController;
    GroupVerified groupVerified;

    private GroupPage(GroupController groupController, GroupVerified groupVerified) {
        this.groupController = groupController;
        this.groupVerified = groupVerified;
    }

    public static GroupPage groupPage(WebDriver driver) {
        return new GroupPage(new GroupController(driver),new GroupVerified(driver));
    }

    public GroupController act() {
        return groupController;
    }

    public GroupVerified verify() {
        return groupVerified;
    }
}
