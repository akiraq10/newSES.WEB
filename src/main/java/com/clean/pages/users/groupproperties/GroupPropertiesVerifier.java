package com.clean.pages.users.groupproperties;

import com.clean.datatest.GroupData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.groupproperties.GroupPropertiesElements.getEle;
import static com.clean.ults.ElementController.verify;

public class GroupPropertiesVerifier {
    WebDriver driver;

     GroupPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Group properties->General page is displayed")
    public GroupPropertiesVerifier isCheckGroupPropertiesGeneralPageDisplay() {
         verify(driver,getEle(driver).groupPropertiesGeneralBreadcrumb, GroupData.GROUP_GENERAL_BREADCRUMB.getValue());
         return this;
    }
    @Step("Verify the Success Alert is displayed")
    public GroupPropertiesVerifier isCheckAlertSuccessDisplay(){
         verify(driver,getEle(driver).alertSuccess);
         return this;
    }
    @Step("Verify the Group properties->Permission page is displayed")
    public GroupPropertiesVerifier isCheckGroupPropertiesPermissionPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesPermissionBreadcrumb, GroupData.GROUP_PERMISSION_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Keys page is displayed")
    public GroupPropertiesVerifier isCheckGroupPropertiesKeyPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesKeysBreadcrumb, GroupData.GROUP_KEYS_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Service Providers page is displayed")
    public GroupPropertiesVerifier isCheckGroupPropertiesServicePageDisplay() {
        verify(driver,getEle(driver).groupPropertiesServiceProviderBreadcrumb, GroupData.GROUP_SERVICE_PROVIDER_BREADCRUMB.getValue());
        return this;
    }
    @Step("Verify the Group properties->Groups page is displayed")
    public GroupPropertiesVerifier isCheckGroupPropertiesGroupPageDisplay() {
        verify(driver,getEle(driver).groupPropertiesGroupsBreadcrumb, GroupData.GROUP_GROUPS_BREADCRUMB.getValue());
        return this;
    }
}
