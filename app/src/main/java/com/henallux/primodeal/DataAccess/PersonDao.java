package com.henallux.primodeal.DataAccess;

import com.google.gson.reflect.TypeToken;
import com.henallux.primodeal.Model.LoginForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.*;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonReturnModel;

/**
 * Created by bil on 19-11-17.
 */

public class PersonDao {

    private static PersonReturnModel _user;

    private static <T> T jsonToObject(String jsonString, Class<T> clas)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clas);
    }

    private static String getResult(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        return result.toString();
    }


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
            String result = getResult(connection.getInputStream());

            if(code ==200){
               /* BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String stringeJSON = "", line;
                while ((line = reader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }
                reader.close();
                System.out.println(stringBuilder);*/

               _user = (PersonReturnModel)jsonToObject(result, PersonReturnModel.class);


                System.out.println(result);
                System.out.println(_user.toString());

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
