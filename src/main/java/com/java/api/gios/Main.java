package com.java.api.gios;

import com.java.api.gios.sensor.Sensor;
import com.java.api.gios.sensor.SensorData;
import com.java.api.gios.sensor.SensorDataValue;
import com.java.api.gios.station.AirQualityIndex;
import com.java.api.gios.station.Station;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        GIOSClient client = new GIOSClient();
//        List<Station> stations = client.fetchAllStations();
//        stations.forEach((station) -> {
//            System.out.println(station);
//            System.out.println(station.getCity());
//            System.out.println(station.getCity().getCommune());
//        });
//
//        List<Sensor> sensors = client.fetchAllSensorsFromStation(10374);
//        sensors.forEach((sensor -> {
//            System.out.println(sensor);
//            System.out.println(sensor.getParam());
//        }));
//
//        SensorData sensorData = client.fetchSensorData(16147);
//        System.out.println(sensorData);
//        System.out.println(Arrays.toString(sensorData.getValues()));
//        System.out.println(sensorData.getValues().length);
//
//        AirQualityIndex airQuaility = client.fetchStationAirQualityIndex(10374);
//        System.out.println(airQuaility);
//
//        List<Station> opoleStations = client.fetchStationFrom("Opole");
//        opoleStations.forEach((station) -> {
//            System.out.println(station);
//            System.out.println(station.getCity());
//            System.out.println(station.getCity().getCommune());
//        });
//
//        List<Sensor> opoleSensors = client.fetchSensorFrom("Opole");
//        opoleSensors.forEach((sensor -> {
//            System.out.println(sensor);
//            System.out.println(sensor.getParam());
//        }));
////
//        HashMap<Integer, List<SensorDataValue>> opoleSensorData = client.fetchSensorDataFrom("Wrocław");
//        opoleSensorData.forEach((sensorId, sensorData)-> {
//            System.out.println(sensorId);
//            System.out.println(sensorData);
//        });
        String param = "PM10";
//        HashMap<Integer, List<SensorDataValue>> opoleSomeSensorData = client.fetchSensorSpecificDataFrom("Opole", param);
//        opoleSomeSensorData.forEach((sensorId, sensorValues) -> {
//            System.out.println("Opole");
//            System.out.println(sensorId);
//            System.out.println(sensorValues);
//        });
//
//        HashMap<Integer, List<SensorDataValue>> wroclawSomeSensorData = client.fetchSensorSpecificDataFrom("Wrocław", param);
//        wroclawSomeSensorData.forEach((sensorId, sensorValues) -> {
//            System.out.println("Wrocław");
//            System.out.println(sensorId);
//            System.out.println(sensorValues);
//        });
//        Station station = client.findNearestStationFor(50.8275855, 15.5211659, "PM10");
//        if (station != null) {
//            System.out.println(station);
//            System.out.println(station.getCity());
//            System.out.println(station.getCity().getCommune());
//        }
        Sensor sensor = client.findNearestSensorFor(50.8275855, 15.5211659, "PM10");
        if (sensor != null) {
            System.out.println(sensor);
            SensorDataValue lastValue = client.fetchLatestDataValueFrom(sensor.getId());
            System.out.println(lastValue);
        }
    }
}
