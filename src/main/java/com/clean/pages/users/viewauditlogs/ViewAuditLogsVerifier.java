package com.clean.pages.users.viewauditlogs;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.viewauditlogs.ViewAuditLogsElements.getElem;
import static com.clean.ults.ElementController.verify;

public class ViewAuditLogsVerifier {
    WebDriver driver;

    public ViewAuditLogsVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify The View Audit Logs Page is displayed")
    public ViewAuditLogsVerifier isCheckViewAuditLogsPageDisplay() {
        verify(driver,getElem(driver).viewAuditLogBreadcrumb);
        return this;
    }
}
