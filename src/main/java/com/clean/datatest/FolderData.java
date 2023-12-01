package com.clean.datatest;

public enum FolderData {
    FOLDER_1_CHAR("k"),
    FOLDER_64_CHAR("this is the test case to create a folder with over 64 characters kkk"),
    FOLDER_DESCRIPTION("Hell word"),
    GROUP_SUB("Group_Sub1"),
    USER_SUB("User_sub1"),
    PASSWORD_USER_SUB("1234567890"),
    RMCE_CHALLENGE_TITLE("RMCE Challenge Response"),
    DELETE_FOLDER_CONFIRM("Warning ! You are about to delete a folder that may:\n" +
            "user(s), key(s), and device(s). All references to this folder will be removed from the Users and Devices views."),
    DELETE_FOLDER_SUCCESS_MSG("Command has been saved successfully."),
    FOLDER_SUB("Folder_Sub1"),
    FOLDER_RENAME("Folder_Rename"),
    FOLDER_NEW("Folder_new"),
    FOLDER_DELETE("Text");



    String value;
    FolderData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }


}
