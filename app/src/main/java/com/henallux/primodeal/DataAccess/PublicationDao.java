package com.henallux.primodeal.DataAccess;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.henallux.primodeal.Model.Publication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by bil on 26-02-18.
 */

public class PublicationDao {

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

    public List<Publication> Get() throws Exception {
        URL url = new URL("https://webapplicationbetterdeal20180130015708.azurewebsites.net/api/publications");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type","application/json");

        connection.connect();


        String result = getResult(connection.getInputStream());
        connection.disconnect();

        Type listType = new TypeToken<List<Publication>>(){}.getType();
        List<Publication> list = new Gson().fromJson(result, listType);

        System.out.println(list);

        return list;
    }

    public Publication Get(Integer idPublication) throws Exception {
        URL url = new URL("https://webapplicationbetterdeal20180130015708.azurewebsites.net/api/publications/"+idPublication);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type","application/json");

        connection.connect();


        String result = getResult(connection.getInputStream());
        connection.disconnect();

        Type type = new TypeToken<Publication>(){}.getType();
        Publication publication = new Gson().fromJson(result, type);

        System.out.println(publication.getTitle());

        return publication;
    }

    public void deletePublication(Integer idPublication) throws Exception{
        URL url = new URL("https://webapplicationbetterdeal20180130015708.azurewebsites.net/api/publications/"+idPublication);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-type","application/json");

        connection.connect();


        String result = getResult(connection.getInputStream());
        connection.disconnect();

    }

    public int postPublication(String title, String description, Integer yes, Integer no, Integer dontknow) throws Exception{
        int code = 0;
        Gson gson = new Gson();
        Publication model = new Publication(title,description, PersonDao._user.id);
        String stringJSON = gson.toJson(model);
        System.out.println(stringJSON);
        try{
        URL url = new URL("https://webapplicationbetterdeal20180130015708.azurewebsites.net/api/publications");
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
        connection.disconnect();}
        catch(Exception e){
            System.out.println("catch new post dao"+e.getMessage().toString());
        }

        return code;
    }

}
