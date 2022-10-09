
package com.weatherApp;

/**
 *
 * @author Hakim
 */
public class Weather {
   private String condition;
   private String icon;
   private double temp;
   private double temp_min;
   private double temp_max;
   private double pressure;
   private double humidity;
   private double wind_speed;
   private int sun_rise;
   private int sun_set;

    public Weather(String condition, String icon, double temp, double temp_min, double temp_max, double pressure, double humidity, double wind_speed, int sun_rise, int sun_set) {
        this.condition = condition;
        this.icon = icon;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.sun_rise = sun_rise;
        this.sun_set = sun_set;
    }

    public Weather() {
    }

   
   
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getSun_rise() {
        return sun_rise;
    }

    public void setSun_rise(int sun_rise) {
        this.sun_rise = sun_rise;
    }

    public int getSun_set() {
        return sun_set;
    }

    public void setSun_set(int sun_set) {
        this.sun_set = sun_set;
    }

    @Override
    public String toString() {
        return "Weather{" + "condition=" + condition + ", icon=" + icon + ", temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", pressure=" + pressure + ", humidity=" + humidity + ", wind_speed=" + wind_speed + ", sun_rise=" + sun_rise + ", sun_set=" + sun_set + '}';
    }
   
   
}
