package com.henallux.primodeal.Model;

/**
 * Created by bil on 04-02-18.
 */

public class PersonReturnModel {

    String id, email, password, userName;

    public PersonReturnModel(String id, String email, String password, String userName){}

    public String toString(){
        return "Id : "+id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

