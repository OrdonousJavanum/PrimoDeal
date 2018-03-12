package com.henallux.primodeal.DataAccess;

import com.henallux.primodeal.Model.LoginForm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;
import com.henallux.primodeal.Model.Person;

/**
 * Created by bil on 19-11-17.
 */

public class PersonDao {


    public int login(String email, String password) throws  Exception {

        int code=-1;
        Gson gson = new Gson();
        LoginForm model = new LoginForm(email,password);
        String stringJSON = gson.toJson(model);
        System.out.println(stringJSON.toString());
        try{

            URL url = new URL("http://webapplicationbetterdeal20180130015708.azurewebsites.net/api/jwt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type","application/json");
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);
            //OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            connection.connect();



            writer.write(stringJSON.toString());
            writer.flush();
            writer.close();
            out.close();
            code=connection.getResponseCode();

            if(code ==200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String stringeJSON = "", line;
                while ((line = reader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }
                reader.close();
                System.out.println(code);

            }
            System.out.println(code);

            connection.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return code;
    }

    public int inscription(String userName,String password,String nameShop, String addressShop ,String status) throws Exception
    {
        int code =-1;

        Gson gson = new Gson();
        Person model;
        if(nameShop == null || nameShop.equals(""))
        {
            model = new Person(userName,password, status);
        }
        else
        {
            model = new Person(userName,password,nameShop,addressShop,status);
        }
        String stringJSON = gson.toJson(model);
        System.out.println(stringJSON.toString());
        try{
            URL url = new URL("http://webapplicationbetterdeal20180130015708.azurewebsites.net/api/Account");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type","application/json");
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);
            connection.connect();

            writer.write(stringJSON.toString());
            writer.flush();
            writer.close();
            out.close();
            code=connection.getResponseCode();
            connection.disconnect();
            if(code ==201){
                System.out.print("oké inscrit");
            }
        }catch(Exception e){ e.printStackTrace(); }
        return code;
    }


}
