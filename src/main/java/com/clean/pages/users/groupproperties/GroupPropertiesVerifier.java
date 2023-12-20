package com.clean.pages.users.groupproperties;

import com.clean.datatest.GroupData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.groupproperties.GroupPropertiesElements.getEle;
import static com.clean.ults.ElementController.verify;
import static com.clean.ults.ElementController.verifyElementNotDisplayInTable;

public class GroupPropertiesVerifier {
    WebDriver driver;

     GroupPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Group properties->General page is displayed")
    public GroupPropertiesVerifier isCheckGeneralPageDisplay() {
         verify(driver,getEle(driver).groupPropertiesGeneralBreadcrumb, GroupData.GROUP_GENERAL_BREADCRUMB.getValue());
         return this;
    }
    @Step("Verify the Success Alert is displayed")
    public GroupPropertiesVerifier isCheckAlertSuccessDisplay(){
         verify(driver,getEle(driver).alertSuccess);
         return this;
    }
    @Step("Verify the Group properties->Permission page is displayed")
    public GroupPropertiesVerifier isCheckPermissionPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesPermissionBreadcrumb, GroupData.GROUP_PERMISSION_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Keys page is displayed")
    public GroupPropertiesVerifier isCheckKeyPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesKeysBreadcrumb, GroupData.GROUP_KEYS_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Service Providers page is displayed")
    public GroupPropertiesVerifier isCheckServiceProviderPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesServiceProviderBreadcrumb, GroupData.GROUP_SERVICE_PROVIDER_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Groups page is displayed")
    public GroupPropertiesVerifier isCheckGroupsPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesGroupsBreadcrumb, GroupData.GROUP_GROUPS_BREADCRUMB.getValue());
        return this;
    }

    @Step("Verify the Key: {keyName} is removed in folder success")
    public GroupPropertiesVerifier isCheckKeyIsRemoved(String keyName) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getEle(driver).selectTable,keyName);
        return this;
    }
    @Step("Verify the Key: {groupName} is removed in folder success")
    public GroupPropertiesVerifier isCheckGroupIsRemoved(String groupName) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getEle(driver).selectTable,groupName);
        return this;
    }
    @Step("Verify the Key: {SPName} is removed in folder success")
    public GroupPropertiesVerifier isCheckSPIsRemoved(String SPName) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getEle(driver).selectTable,SPName);
        return this;
    }
}
