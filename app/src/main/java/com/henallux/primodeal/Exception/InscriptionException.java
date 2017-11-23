package com.henallux.primodeal.Exception;

/**
 * Created by bil on 19-11-17.
 */

public class InscriptionException extends Exception {

    private int code;

    public InscriptionException(int code)
    {
        this.code = code;
    }

    public String getMessage() {
        //voir pour traduction
        String msg = "Error : ";
        if (code == 1)
            msg += "Invalid first name\n";
        if (code == 2)
            msg += "Invalid last name\n";
        if(code == 3)
            msg +="Invalid email\n";
        if(code == 4)
            msg +="Invalid password\n";
        if(code == 5)
            msg +="Invalid shop name";
        if(code == 6)
            msg +="Invalid description shop";
        if(code == 7)
            msg += "Invalid city";
        if(code ==8)
            msg +="Invalid street";
        return msg;
    }

}
