package org.example;

public class Constants {
    public static final String BASE_URL = "http://api.gios.gov.pl/pjp-api/rest";
    public static final String FETCH_ALL_STATIONS_URL = BASE_URL + "/station/findAll";
    public static final String FETCH_ALL_SENSORS_FROM_STATION_URL = BASE_URL + "/station/sensors/%s";
    public static final String FETCH_SENSOR_DATA_URL = BASE_URL + "/data/getData/%s";

}
