package com.henallux.primodeal.Exception;

/**
 * Created by bil on 23-11-17.
 */

public class PublicationException extends Exception {

    private int code;

    public PublicationException(int code)
    {
        this.code = code;
    }

    public String getMessage() {
        String msg = "Error : ";
        if (code == 1)
            msg += "Invalid title\n";
        if(code == 2)
            msg +="Invalid description\n";
        if(code == 3)
            msg +="Invalid question\n";
        if(code == 4)
            msg +="Invalid answer\n";
        return msg;
    }

}
