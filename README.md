## GIOS API Client for Java applications

1. Apply jar file to your project.
2. Import client and/or related models.
    ```
        Example: 
        import com.java.api.gios.GIOSClient;
        import com.java.api.gios.sensor.Sensor;
        import com.java.api.gios.sensor.SensorData;
        import com.java.api.gios.sensor.SensorDataValue;
        import com.java.api.gios.station.AirQualityIndex;
        import com.java.api.gios.station.Station;
    ```
3. Enjoy using.
    ```
        Example: 
        GIOSClient client = new GIOSClient();
   
        List<Station> stations = client.fetchAllStations();

        List<Sensor> sensors = client.fetchAllSensorsFromStation(10374);

        SensorData sensorData = client.fetchSensorData(16147);
        
        AirQualityIndex airQuaility = client.fetchStationAirQualityIndex(10374);

        List<Station> opoleStations = client.fetchStationFrom("Opole");

        List<Sensor> opoleSensors = client.fetchSensorFrom("Opole");
        
        HashMap<Integer, List<SensorDataValue>> opoleSensorData = client.fetchSensorDataFrom("Opole");

        HashMap<Integer, List<SensorDataValue>> opolePM10SensorData = client.fetchSensorSpecificDataFrom("Opole", "PM10");

        Station station = client.findNearestStationFor(50.7393909, 17.9617396, "CO");
 
        Sensor sensor = client.findNearestSensorFor(50.7393909, 17.9617396, "CO");
    ```