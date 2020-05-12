package com.java.api.gios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.api.gios.sensor.Sensor;
import com.java.api.gios.sensor.SensorData;
import com.java.api.gios.station.AirQualityIndex;
import com.java.api.gios.station.Station;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GIOSClient
{
    public GIOSClient() {}

    private HttpRequest _prepareRequest(String uri) {
        return HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();
    }

    private HttpResponse<String> _fetchData(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = _prepareRequest(uri);
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Station> fetchAllStations() throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(Constants.FETCH_ALL_STATIONS_URL);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public List<Sensor> fetchAllSensorsFromStation(int stationId) throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(String.format(Constants.FETCH_ALL_SENSORS_FROM_STATION_URL, stationId));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public SensorData fetchSensorData(int sensorId) throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(String.format(Constants.FETCH_SENSOR_DATA_URL, sensorId));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public AirQualityIndex fetchStationAirQualityIndex(int stationId) throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(String.format(Constants.FETCH_STATION_AIR_QUALITY_URL, stationId));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public List<Station> fetchStationFrom(String cityName) throws IOException, InterruptedException {
        List<Station> allStations = fetchAllStations();
        return allStations.stream().filter(station ->
                station.getCity().getName().equals(cityName))
                .collect(Collectors.toList());
    }

    public List<Sensor> fetchSensorFrom(String cityName) throws IOException, InterruptedException {
        List<Station> requestedStations = fetchStationFrom(cityName);
        List<Sensor> citySensors = new ArrayList<>();
        requestedStations.forEach(station -> {
            try {
                citySensors.addAll(fetchAllSensorsFromStation(station.getId()));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        return citySensors;
    }

    public List<SensorData> fetchSensorDataFrom(String cityName) throws IOException, InterruptedException {
        List<Sensor> requestedSensors = fetchSensorFrom(cityName);
        List<SensorData> sensorDataList = new ArrayList<>();
        requestedSensors.forEach(sensor -> {
            try {
                sensorDataList.add(fetchSensorData(sensor.getId()));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        return sensorDataList;
    }

}
