package com.java.api.gios;

import java.text.SimpleDateFormat;

public class Constants {
    public static final String BASE_URL = "http://api.gios.gov.pl/pjp-api/rest";
    public static final String FETCH_ALL_STATIONS_URL = BASE_URL + "/station/findAll";
    public static final String FETCH_ALL_SENSORS_FROM_STATION_URL = BASE_URL + "/station/sensors/%s";
    public static final String FETCH_SENSOR_DATA_URL = BASE_URL + "/data/getData/%s";
    public static final String FETCH_STATION_AIR_QUALITY_URL = BASE_URL + "/aqindex/getIndex/%s";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


}
