package com.clean.pages.users.adduser;


import com.clean.datatest.UserData;

import org.openqa.selenium.WebDriver;

import static com.clean.datatest.UserData.*;
import static com.clean.ults.ElementController.*;

public class AddUserController {
    private WebDriver driver ;

    public AddUserController(WebDriver driver) {
        this.driver=driver;

    }

    public AddUserController fillUserID(String userID ) {
        fill(driver, AddUserElement.getAddUserElem(driver).userIDTXT,userID);
        return this;
    }

    public AddUserController fillPWD(String password ) {
        fill(driver, AddUserElement.getAddUserElem(driver).passwordTXT,password);
        return this;
    }

    public AddUserController fillFirstName(String firstname ) {
        fill(driver, AddUserElement.getAddUserElem(driver).firstNameTXT,firstname);
        return this;
    }

    public AddUserController fillLastName(String lastname ) {
        fill(driver, AddUserElement.getAddUserElem(driver).lastNameTXT,lastname);
        return this;
    }

    public AddUserController fillEmail(String email ) {
        fill(driver, AddUserElement.getAddUserElem(driver).emailTXT,email);
        return this;
    }

    public AddUserController fillDescription(String description ) {
        fill(driver, AddUserElement.getAddUserElem(driver).descriptionTXT,description);
        return this;
    }

    public AddUserController checkFinalPassword() {
        check(driver, AddUserElement.getAddUserElem(driver).finalPWDCheckBox);
        return this;
    }

    public AddUserController unCheckFinalPassword() {
        uncheck(driver, AddUserElement.getAddUserElem(driver).finalPWDCheckBox);
        return this;
    }
    public AddUserController clickOnUserType(){
        click(driver, AddUserElement.getAddUserElem(driver).userTypeListBox);
        return this;
    }

    public AddUserController selectUserType(UserData type) {

        switch (type){
            case REGULAR :
                select(AddUserElement.getAddUserElem(driver).userTypeOpt,REGULAR.getValue());
                break;
            case AUTO:
                select(AddUserElement.getAddUserElem(driver).userTypeOpt,AUTO.getValue());
                break;
            case TEMPORARY:
                select(AddUserElement.getAddUserElem(driver).userTypeOpt, TEMPORARY.getValue());
                break;
            default:
                System.out.println(type + "NOT available");
                break;

        }
        return this;
    }

    public AddUserController clickOnSaveBtn(){
        click(driver, AddUserElement.getAddUserElem(driver).saveBtn);
        return this;
    }


}
