package com.clean.datatest;

public enum AdminRoleData {
    ADMIN_ROLE_NAME("Administrator"),
    HELPDESK_ROLE_NAME("Helpdesk"),
    DESKTOP_SUPPORT_ROLE_NAME("Desktop Support");
    String value;

    AdminRoleData(String value) {
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
