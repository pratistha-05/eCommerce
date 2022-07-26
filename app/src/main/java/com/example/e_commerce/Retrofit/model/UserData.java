package com.example.e_commerce.Retrofit.model;

import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("phoneNo")
    public String phoneNo;

    public UserData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }




}
