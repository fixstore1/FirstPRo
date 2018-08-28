package com.example.dell.firstpro.WebService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIhandler {

    String result = "";

    public String getApi() {
        try {
            URL url = new URL("https://api.androidhive.info/contacts/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            result = ReadJson(inputStream);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String ReadJson(InputStream inputStream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        String data;

        while ((data = reader.readLine()) != null) {
            line += data + "/n";

        }
        inputStream.close();
        return line;
    }


}
