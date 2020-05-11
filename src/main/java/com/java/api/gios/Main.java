package com.java.api.gios;

import com.java.api.gios.sensor.Sensor;
import com.java.api.gios.sensor.SensorData;
import com.java.api.gios.station.AirQualityIndex;
import com.java.api.gios.station.Station;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        GIOSClient client = new GIOSClient();
        List<Station> stations = client.fetchAllStations();
        stations.forEach((station) -> {
            System.out.println(station);
            System.out.println(station.getCity());
            System.out.println(station.getCity().getCommune());
        });

        List<Sensor> sensors = client.fetchAllSensorsFromStation(10374);
        sensors.forEach((sensor -> {
            System.out.println(sensor);
            System.out.println(sensor.getParam());
        }));

        SensorData sensorData = client.fetchSensorData(16147);
        System.out.println(sensorData);
        System.out.println(Arrays.toString(sensorData.getValues()));
        System.out.println(sensorData.getValues().length);

        AirQualityIndex airQuaility = client.fetchStationAirQualityIndex(10374);
        System.out.println(airQuaility);
    }
}
