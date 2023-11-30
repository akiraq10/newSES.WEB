package com.clean.datatest;

public enum FolderData {
    FOLDER_1_CHAR("k"),
    FOLDER_64_CHAR("this is the test case to create a folder with over 64 characters kkk"),
    FOLDER_DESCRIPTION("Hell word");
    String value;
    FolderData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }


}
