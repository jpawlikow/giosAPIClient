package org.example;

import java.io.IOException;
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
    }
}
