
package com.weatherApp;

import java.net.UnknownHostException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author Hakim
 */
public class WeatherApp {
    public static void main(String[] args) throws UnknownHostException {
        Weather weather=MyWeather.getWeather();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        
        double temp=weather.getTemp() - 273.15;
        double temp_min=weather.getTemp_min()- 273.15;
        double temp_max=weather.getTemp_max()- 273.15;
        String cond=weather.getCondition();
        double humidity = weather.getHumidity();
        double pressure = weather.getPressure();
        String icon = weather.getIcon();
        int sun_rise = weather.getSun_rise();
        int sun_set = weather.getSun_set();
        double wind_speed = weather.getWind_speed();
        
        String sunRiseTime=formatter.format(Instant.ofEpochSecond(sun_rise).atZone(ZoneId.systemDefault()));
        String sunSetTime=formatter.format(Instant.ofEpochSecond(sun_set).atZone(ZoneId.systemDefault()));
        
        
         String result="""
        +-------------------------+-------------------------+     
         Condition: %s %s | Date : %s                 
        -----------------------------------------------------
         Temp     : %.2f  c                           
         Max Temp : %.2f  c                           
         Min Temp : %.2f  c                           
        -----------------------------------------------------
         Humidity : %.2f                               
         Pressure : %.2f                               
        -----------------------------------------------------
         Wind Speed : %.2f
        -----------------------------------------------------                                                           
         Sun Rise : %s                                                    
         Sun Set  : %s                                                    
        +----------------------------------------------------+                                                     
                      """.formatted(cond,"u"+icon,dateTimeFormatter.format(LocalDateTime.now()),temp,temp_max,temp_min,humidity,pressure,wind_speed,sunRiseTime,sunSetTime);                                   
        
        System.out.println(result);
    }
}
