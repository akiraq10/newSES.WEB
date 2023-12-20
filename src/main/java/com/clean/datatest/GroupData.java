package com.clean.datatest;

public enum GroupData {
    GROUP_NAME("Group1"),
    GROUP_NAME_TEST_UPDATE("Group2"),
    GROUP_DESCRIPTION("this is description"),
    GROUP_DESCRIPTION_UPDATE("update the description"),
    GROUP_NAME_UPDATE("Group_name_updated"),
    GROUP_GENERAL_BREADCRUMB("Group properties : General"),
    GROUP_PERMISSION_BREADCRUMB("Group properties : Permissions"),
    GROUP_KEYS_BREADCRUMB("Group properties : Keys"),
    GROUP_SERVICE_PROVIDER_BREADCRUMB("Group properties : Service Providers"),
    GROUP_GROUPS_BREADCRUMB("Group properties : Groups"),
    GROUP_SERVICE_PROVIDER_NAME("AzureAD")
    ;

    private String value;

    GroupData(String value) {
        this.value = value;
    }
    public String getValue(){return value;}
}
