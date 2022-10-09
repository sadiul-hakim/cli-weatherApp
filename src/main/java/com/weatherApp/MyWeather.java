package com.weatherApp;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Hakim
 */
public class MyWeather {

    private static final String API_KEY = "85bd99358049737e96d6a045d89763d4";

    public static Weather getWeather() throws UnknownHostException {
        Weather weather = new Weather();
        Location location = GeoLocation.getGeoLocation();
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + location.getLatitude() + "&lon=" + location.getGongitude() + "&appid=" + API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "*/*")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject object = new JSONObject(response.body());

            JSONObject windObject = (JSONObject) object.get("wind");
            JSONObject mainObject = (JSONObject) object.get("main");
            JSONObject sysObject = (JSONObject) object.get("sys");

            JSONArray weatherArr = (JSONArray) object.get("weather");

            Iterator itr1 = weatherArr.iterator();

            while (itr1.hasNext()) {
                JSONObject obj = (JSONObject) itr1.next();

                weather.setCondition(obj.getString("main"));
                weather.setIcon(obj.getString("icon"));
            }

            weather.setTemp(mainObject.getInt("temp"));
            weather.setTemp_max(mainObject.getDouble("temp_max"));
            weather.setTemp_min(mainObject.getDouble("temp_min"));
            weather.setPressure(mainObject.getInt("pressure"));
            weather.setHumidity(mainObject.getInt("humidity"));

            weather.setWind_speed(windObject.getInt("speed"));
            weather.setSun_rise(sysObject.getInt("sunrise"));
            weather.setSun_set(sysObject.getInt("sunset"));

        } catch (IOException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
        }

        return weather;
    }

}
