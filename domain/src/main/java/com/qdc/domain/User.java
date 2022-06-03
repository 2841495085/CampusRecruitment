package com.qdc.domain;

public class User {
    private String uId;
    private String uName;
    private String uMail;
    private String uPassword;
    private String uType;

    public User() {
    }


    public User(String uId, String uName, String uMail, String uPassword, String uType) {
        this.uId = uId;
        this.uName = uName;
        this.uMail = uMail;
        this.uPassword = uPassword;
        this.uType = uType;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uMail='" + uMail + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uType='" + uType + '\'' +
                '}';
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }
}
