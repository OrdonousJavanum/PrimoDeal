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
        return msg;
    }

}
