package com.clean.dataprovider.getdata;

public class LoginData {
    private String username;
    private String pwd;

    public LoginData(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUserName() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
