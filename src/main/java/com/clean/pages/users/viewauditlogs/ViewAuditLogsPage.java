package com.clean.pages.users.viewauditlogs;

import org.openqa.selenium.WebDriver;

public class ViewAuditLogsPage {
    ViewAuditLogsController viewAuditLogsController;
    ViewAuditLogsVerifier viewAuditLogsVerifier;

    private ViewAuditLogsPage(ViewAuditLogsController viewAuditLogsController, ViewAuditLogsVerifier viewAuditLogsVerifier) {
        this.viewAuditLogsController = viewAuditLogsController;
        this.viewAuditLogsVerifier = viewAuditLogsVerifier;
    }
    public static ViewAuditLogsPage viewAuditLogsPage(WebDriver driver){
        return new ViewAuditLogsPage(new ViewAuditLogsController(driver), new ViewAuditLogsVerifier(driver));
    }

    public ViewAuditLogsController act() {
        return viewAuditLogsController;
    }

    public ViewAuditLogsVerifier verify() {
        return viewAuditLogsVerifier;
    }
}
