package com.devmountain.watchlist.services;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class MovieServiceImpl {

    @Transactional
    public List<Object> getTopRated() throws IOException, ParseException {
        List<Object> response = new ArrayList<>();
        URL url = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=02dde39685e92a4ee1848cc2a02fe645&language=en-US&page=1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("GET", "application/json");
        connection.connect();

        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            informationString.append(scanner.nextLine());
        }
        scanner.close();

        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(String.valueOf(informationString));
        JSONArray results = (JSONArray) obj.get("results");
        response.add(results);
        return response;
    }
}
