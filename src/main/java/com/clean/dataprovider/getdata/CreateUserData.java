package com.clean.dataprovider.getdata;

public class CreateUserData {
    private String userID;
    private String userPWD;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String description;
    private String userType;
    private boolean isFinalPwd;



    public CreateUserData(String userID, String userPWD, String userType) {
        this.userID = userID;
        this.userPWD = userPWD;
        this.userType = userType;
    }

    public CreateUserData(String userID, String userPWD, String firstName, String lastName, String phone, String email, String description, String userType,boolean isFinalPwd) {
        this.userID = userID;
        this.userPWD = userPWD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.userType = userType;
        this.isFinalPwd=isFinalPwd;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPWD() {
        return userPWD;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getUserType() {
        return userType;
    }
    public boolean isFinalPwd() {
        return isFinalPwd;
    }

}
