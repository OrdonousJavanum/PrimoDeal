package com.henallux.primodeal.Model;

/**
 * Created by bil on 15-03-18.
 */

public class PersonReturnModel {
    /*
    {"status":null,"nameShop":null,"addressShop":null,"id":"2fab4ef2-6670-4799-bd45-2a1b7c242030","userName":"noub.bil@hotmail.com","normalizedUserName":"NOUB.BIL@HOTMAIL.COM","email":"noub.bil@hotmail.com","normalizedEmail":"NOUB.BIL@HOTMAIL.COM","emailConfirmed":false,"passwordHash":"AQAAAAEAACcQAAAAEIoO98oGZBSDZ3vGwqFP//8hRIvnz36Z0qDiBjkghdUX1RR/OZvT+dEf32m1Fbq/1w==","securityStamp":"e414a08d-5da1-431e-be5d-1567f503d638","concurrencyStamp":"5446797b-0a00-47d0-88a2-2863332f8b32","phoneNumber":null,"phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":true,"accessFailedCount":0}
    */

    public String status, nameShop, addressShop, id, userName, email;

    public PersonReturnModel(String status, String nameShop, String addressShop, String id, String userName, String email){
        this.status = status;
        this.userName = userName;
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }
}
