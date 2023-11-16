package com.clean.datatest;

public enum ProfilesData {
    ENDPOINT_PROFILE_NAME("Endpoint"),
    DESCRIPTION("hello word");
    String value;

    ProfilesData(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
