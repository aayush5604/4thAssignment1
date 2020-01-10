package com.example.a4thassignment.model;

public class User {

    private String fullName;
    private String email;
    private String phoneNo;
    private String password;
    private String smsCode;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public User(String fullName, String email, String phoneNo, String password, String smsCode) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.smsCode = smsCode;
    }
}
