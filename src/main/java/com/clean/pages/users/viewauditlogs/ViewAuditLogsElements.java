package com.clean.pages.users.viewauditlogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAuditLogsElements {
    @FindBy(id = "breadcrumb_User_ViewLogs_4")
    WebElement viewAuditLogBreadcrumb;
    private ViewAuditLogsElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    static ViewAuditLogsElements getElem(WebDriver driver){
        return new ViewAuditLogsElements(driver);
    }
}
