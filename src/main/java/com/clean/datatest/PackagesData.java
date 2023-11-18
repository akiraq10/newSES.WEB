package com.clean.datatest;

public enum PackagesData {
    ENDPOINT_PACKAGE_NAME("Endpoint"),
    MACOS_PACKAGE_NAME("MacOS"),
    ENDPOINT_LINUX_PACKAGE_NAME("Endpoint_Linux"),
    OSA_PACKAGE_NAME("OSA"),
    DESCRIPTION("hello word"),
    PACKAGE_SUCCESS_ALERT("Package was created successfully");
    String value;

    PackagesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
