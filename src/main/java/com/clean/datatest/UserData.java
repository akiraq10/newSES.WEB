package com.clean.datatest;

public enum UserData {
    REGULAR_USERNAME("Regular"),
    REGULAR_USERNAME2("Regulr2"),
    TEMPORARY_USERNAME("Temp"),
    AUTO_USERNAME("Auto"),
    USER_PASSWORD("12345678"),
    GROUP_NAME("Group1"),
    FOLDER_NAME("Folder1"),
    REGULAR("Regular User"),
    AUTO("Autoboot User"),
    TEMPORARY("Temporary User"),
    DESCRIPTION("hello word"),


    CONFIRM_DELETE_MSG("Warning ! You are about to delete a folder that may contain user(s), key(s), and device(s). All references to this folder will be removed from the Users and Devices views."),
    FAILPW_RULE_MSG("Password is too short. See minimum password length in password rules"),
    USERPW_ERROR("The password may not be empty, nor consist only of spaces"),
    EMAIL_ERROR("Email format is not valid. ex: email@example.com"),
    DEVICE_KEY("<DEVICE_KEY>"),
    DELETE_TEMPUSER_ASSINGEDPKG_MSG("This user account is attached to an installation package. If you delete this user account, you will be required to update your installation package settings accordingly. Do you want to continue with the user deletion?"),
    DELETE_USER_MSG("Delete the selected user(s)?");
    String value;
    UserData(String _value) {
        this.value=_value;
    }
    public String getValue(){
        return value;
    }
}
