package com.clean.dataprovider.getdata;

public class ProfileData {
    private String profileName;
    private String comments;
    private String targetPlatform;
    private String profileType;

    public ProfileData(String profileName, String comments, String targetPlatform, String profileType) {
        this.profileName = profileName;
        this.comments = comments;
        this.targetPlatform = targetPlatform;
        this.profileType = profileType;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getComments() {
        return comments;
    }

    public String getTargetPlatform() {
        return targetPlatform;
    }

    public String getProfileType() {
        return profileType;
    }
}
