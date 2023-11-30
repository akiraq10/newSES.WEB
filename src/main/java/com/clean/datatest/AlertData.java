package com.clean.datatest;

public enum AlertData {
    ALERT_SUCCESS("Operation succeeded."),
    ALERT_64_CHARACTERS("Failed to add folder. Folder name exceeds the maximum length of 64 characters.");
    String value;

    AlertData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
