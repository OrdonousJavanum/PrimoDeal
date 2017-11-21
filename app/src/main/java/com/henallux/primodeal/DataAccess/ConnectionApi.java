package com.henallux.primodeal.DataAccess;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by bil on 21-11-17.
 */

public class ConnectionApi {

    private static final String TAG = ConnectionApi.class.getSimpleName();

    public HttpURLConnection getConnection(String reqUrl, String method) throws  IOException
    {

            URL url = new URL(reqUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            if(method.equals("POST") || method.equals("PUT"))
                connection.setDoOutput(true);


            if(method.equals("GET"))
                connection.setDoInput(true);
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());


            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            return connection;

    }

    public void writeConnection(HttpURLConnection connection, String Json) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        connection.connect();
        writer.write(Json);
        writer.flush();
        writer.close();
        outputStream.close();
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
