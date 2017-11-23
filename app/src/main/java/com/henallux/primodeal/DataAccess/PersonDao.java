package com.henallux.primodeal.DataAccess;

import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;

/**
 * Created by bil on 19-11-17.
 */

public class PersonDao implements PersonInterface {

    @Override
    public void addPerson(Person person) throws  Exception{
        System.out.println("add personne dataAccss ********************************************");

        Gson gson = new Gson();
        String personJSON = gson.toJson(person);


        URL url = new URL("http://webapplicationprimodeal20171101074235.azurewebsites.net/api/sellers");
        URLConnection connection = url.openConnection();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        StringBuilder stringBuilder = new StringBuilder();

        bufferedWriter.write(personJSON);
        bufferedWriter.close();

    }
}
