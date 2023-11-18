package com.clean.datatest;

public enum ProfilesData {
    ENDPOINT_PROFILE_NAME("Endpoint"),
    MACOS_PROFILE_NAME("MacOS"),
    ENDPOINT_LINUX_PROFILE_NAME("Endpoint_Linux"),
    OSA_PROFILE_NAME("OSA"),
    DESCRIPTION("hello "),
    PROFILE_SUCCESS_ALERT("Profile was created successfully");
    String value;

    ProfilesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
