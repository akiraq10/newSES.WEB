package com.clean.pages.users.grouppage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.grouppage.GroupElements.getEle;
import static com.clean.ults.ElementController.verify;

public class GroupVerified {
    WebDriver driver;

    GroupVerified(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Group: {groupName} page is displayed")
    public GroupVerified isCheckGroupPageDisplay(String groupName) {
        verify(driver,getEle(driver).groupBreadcrumb,groupName);
        return this;
    }
    @Step("Verify the '{expect}' alert is displayed")
    public GroupVerified isCheckAlertSuccessDisplayed(String expect){
        verify(driver,getEle(driver).successAlert,expect);
        return this;
    }
}
