package com.java.api.gios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.api.gios.sensor.Sensor;
import com.java.api.gios.sensor.SensorData;
import com.java.api.gios.sensor.SensorDataValue;
import com.java.api.gios.station.AirQualityIndex;
import com.java.api.gios.station.Station;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

// https://powietrze.gios.gov.pl/pjp/content/api
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

    public List<SensorDataValue> fetchDataValuesFrom(int sensorId) throws IOException, InterruptedException {
        SensorData sensorData = fetchSensorData(sensorId);
        return Arrays.asList(sensorData.getValues());
    }

    public SensorDataValue fetchLatestDataValueFrom(int sensorId) throws IOException, InterruptedException {
        List<SensorDataValue> sensorDataValues = fetchDataValuesFrom(sensorId);
        Optional<SensorDataValue> firstValue = sensorDataValues.stream().filter(
                sensorDataValue -> sensorDataValue.getValue() != null).findFirst();
        return firstValue.orElse(null);
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

    public HashMap<Integer, List<SensorDataValue>> fetchSensorDataFrom(String cityName) throws IOException, InterruptedException {
        List<Sensor> requestedSensors = fetchSensorFrom(cityName);
        HashMap<Integer, List<SensorDataValue>> sensorDataMap = new HashMap<Integer, List<SensorDataValue>>();
        requestedSensors.forEach(sensor -> {
            try {
                sensorDataMap.put(sensor.getId(), Arrays.asList(fetchSensorData(sensor.getId()).getValues()));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        return sensorDataMap;
    }

    public HashMap<Integer, List<SensorDataValue>> fetchSensorSpecificDataFrom(String cityName, String key)
            throws IOException, InterruptedException {
        return fetchSensorSpecificDataFrom(cityName, key, false);
    }

    public HashMap<Integer, List<SensorDataValue>> fetchSensorSpecificDataFrom(String cityName, String key, boolean latest)
            throws IOException, InterruptedException {
        List<Sensor> requestedSensors = fetchSensorFrom(cityName);
        HashMap<Integer, List<SensorDataValue>> sensorDataMap = new HashMap<Integer, List<SensorDataValue>>();
        requestedSensors.forEach(sensor -> {
            try {
                List<SensorDataValue> currentDataValue = new ArrayList<>();
                if (sensor.getParam().getParamCode().equals(key)) {
                    SensorData sensorDataSet = fetchSensorData(sensor.getId());
                    List<SensorDataValue> sensorDataSetValues = Arrays.asList(sensorDataSet.getValues());
                    if (latest) {
                        Optional<SensorDataValue> firstValue = sensorDataSetValues.stream().filter(
                                sensorDataValue -> sensorDataValue.getValue() != null).findFirst();
                        if (firstValue.isPresent()) {
                            currentDataValue.add(firstValue.get());
                            sensorDataMap.put(sensor.getId(), currentDataValue);
                        }
                    } else {
                        sensorDataMap.put(sensor.getId(), sensorDataSetValues);
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        return sensorDataMap;
    }

    public Station findNearestStationFor(double coordLat, double coordLon, String key) throws IOException, InterruptedException {
        List<Integer> stationIdBlackList = new ArrayList<>();
        List<Station> allStations = fetchAllStations();
        HashMap<Integer, Double> distanceMap = new HashMap<Integer, Double>();
        allStations.forEach(station -> {
            distanceMap.put(station.getId(), Util.computeDistance(coordLat, coordLon, station.getGegrLat(), station.getGegrLon()));
        });
        Double smallestDistance = null;
        Integer closestStation = null;
        for (Integer stationId: distanceMap.keySet()) {
            Double stationDistance = distanceMap.get(stationId);
            if (smallestDistance == null || smallestDistance > stationDistance) {
                if (fetchAllSensorsFromStation(stationId).stream().anyMatch(sensor -> sensor.getParam().getParamCode().equals(key))) {
                    smallestDistance = stationDistance;
                    closestStation = stationId;
                }
            }
        };

        if (closestStation != null) {
            Integer finalClosestStation = closestStation;
            Optional<Station> resultStation = allStations.stream().filter(station -> station.getId() == finalClosestStation).findFirst();
            return resultStation.orElse(null);
        }
        return null;
    }

    public Sensor findNearestSensorFor(double coordLat, double coordLon, String key) throws IOException, InterruptedException {
        Station nearestStation = findNearestStationFor(coordLat, coordLon, key);
        if (nearestStation == null) return null;
        Optional<Sensor> collectedSensor = fetchAllSensorsFromStation(nearestStation.getId()).stream().filter(
                sensor -> sensor.getParam().getParamCode().equals(key)).findFirst();
        return collectedSensor.orElse(null);
    }
}
