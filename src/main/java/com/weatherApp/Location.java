package com.weatherApp;

/**
 *
 * @author Hakim
 */
public class Location {
    private String latitude;
    private String gongitude;
    private String ip;

    public Location(String latitude, String gongitude, String ip) {
        this.latitude = latitude;
        this.gongitude = gongitude;
        this.ip = ip;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getGongitude() {
        return gongitude;
    }

    public void setGongitude(String gongitude) {
        this.gongitude = gongitude;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Location{" + "latitude=" + latitude + ", gongitude=" + gongitude + ", ip=" + ip + '}';
    }
    
    
}
