package com.kaufland.vmdb.access;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class OmdbAccess {

    public static JSONObject queryMovieByTitle(String title){
        String url = "https://www.omdbapi.com/?apikey=53f133e4&t=";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://www.omdbapi.com/?apikey=53f133e4&t="+title.replaceAll("\\s","+").replaceAll("'", "%27")).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            return new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
