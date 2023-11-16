package com.clean.datatest;

public enum PackagesData {
    ENDPOINT_PACKAGE_NAME("Endpoint"),
    DESCRIPTION("hello word");
    String value;

    PackagesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
