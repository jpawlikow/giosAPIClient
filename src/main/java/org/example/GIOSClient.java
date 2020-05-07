package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

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
        HttpRequest request = _prepareRequest(Constants.BASE_URL + uri);
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Station> fetchAllStations() throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(Constants.FETCH_ALL_STATIONS_URI);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public List<Sensor> fetchAllSensorsFromStation(int id) throws IOException, InterruptedException {
        HttpResponse<String> response = _fetchData(String.format(Constants.FETCH_ALL_SENSORS_FROM_STATION_URI, id));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }
}
