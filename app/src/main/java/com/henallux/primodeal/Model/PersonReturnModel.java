package com.henallux.primodeal.Model;

/**
 * Created by bil on 04-02-18.
 */

public class PersonReturnModel {

    public String access_token;

    public PersonReturnModel(String access_token){
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }
}

