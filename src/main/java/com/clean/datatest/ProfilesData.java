package com.clean.datatest;

public enum ProfilesData {
    ENDPOINT_PROFILE_NAME("Windows-Endpoint"),
    MACOS_PROFILE_NAME("MacOS"),
    ENDPOINT_LINUX_PROFILE_NAME("Linux_Endpoint"),
    OSA_PROFILE_NAME("OSA_Endpoint"),
    DESCRIPTION("hello work"),
    TARGET_PLATFORM_ENDPOINT("Endpoint Devices"),
    OSA_PROFILE_TYPE("SecureDoc for OSA"),
    ENDPOINT_PROFILE_TYPE("SecureDoc Enterprise for Windows"),
    MACOS_PROFILE_TYPE("SecureDoc Enterprise for macOS"),
    LINUX_PROFILE_TYPE("SecureDoc Enterprise for Linux"),
    PROFILE_SUCCESS_ALERT("Profile was created successfully");
    String value;

    ProfilesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
