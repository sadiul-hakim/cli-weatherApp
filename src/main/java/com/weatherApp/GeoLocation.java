package com.weatherApp;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;


/**
 *
 * @author Hakim
 */
public class GeoLocation {

    private static final String API_KEY = "234dfc960b1347e38e82cf7095a59f7f";
    private static final String MY_URL = "https://api.ipgeolocation.io/ipgeo?apiKey=";

    public static Location getGeoLocation() throws UnknownHostException {
        Location location = null;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MY_URL+API_KEY))
                .header("Accept", "*/*")
                .header("User-Agent", "Thunder Client (https://www.thunderclient.com)")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response=null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            
            JSONObject json=new JSONObject(response.body());
            
            location=new Location(json.getString("latitude"), json.getString("longitude"), json.getString("ip"));
            
        } catch (IOException ex) {
            Logger.getLogger(GeoLocation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GeoLocation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return location;
    }

}
