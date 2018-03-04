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
        URL url = new URL("http://webapplicationbetterdeal20180130015708.azurewebsites.net/api/publications");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type","application/json");
        connection.setDoOutput(true);
        OutputStream out = connection.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        connection.connect();


        String result = getResult(connection.getInputStream());
        connection.disconnect();

        Type listType = new TypeToken<List<Publication>>(){}.getType();
        List<Publication> list = new Gson().fromJson(result, listType);

        System.out.println(list);

        return list;
    }

}
