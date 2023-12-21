package com.clean.datatest;

public enum PackagesData {
    ENDPOINT_PACKAGE_NAME("Windows-Endpoint"),
    MACOS_PACKAGE_NAME("MacOS"),
    ENDPOINT_LINUX_PACKAGE_NAME("Linux_Endpoint"),
    OSA_PACKAGE_NAME("OSA_Endpoint"),
    DESCRIPTION("hello word"),
    TARGET_PLATFORM_ENDPOINT("Endpoint Devices"),
    OSA_PACKAGE_TYPE("SecureDoc for OSA"),
    ENDPOINT_PACKAGE_TYPE("SecureDoc Enterprise for Windows"),
    MACOS_PACKAGE_TYPE("SecureDoc Enterprise for macOS"),
    LINUX_PACKAGE_TYPE("SecureDoc Enterprise for Linux"),
    PACKAGE_SUCCESS_ALERT("Package was created successfully"),
    OSA_INITIAL_PASSWORD("123456789");
    String value;

    PackagesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
