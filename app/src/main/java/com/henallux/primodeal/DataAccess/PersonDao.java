package com.henallux.primodeal.DataAccess;

import com.henallux.primodeal.Model.LoginForm;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;

/**
 * Created by bil on 19-11-17.
 */

public class PersonDao implements PersonInterface {

    @Override
    public void login(LoginForm loginForm) throws  Exception{
       System.out.println("add personne dataAccss ********************************************");
        System.out.println(loginForm.getEmail()+" "+loginForm.getPassword());
/*
        Gson gson = new Gson();

        String loginJSON = gson.toJson(loginForm);



        URL url = new URL("http://webapplicationbetterdeal20180130015708.azurewebsites.net/api/jwt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("Post");
        connection.setRequestProperty("Content-type", "application/json");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        connection.connect();



        int codeResult = connection.getResponseCode();
        if(codeResult == 200)
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        }


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        StringBuilder stringBuilder = new StringBuilder();

        bufferedWriter.close();*/

    }


}
