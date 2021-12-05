package com.example.cryptonews;

public class User {

    public String userName;
    public String userPassword;
    public String email;

    public User() {

    }
    public User(String userName, String password, String email){
        this.userName = userName;
        this.userPassword = password;
        this.email = email;
    }
}
