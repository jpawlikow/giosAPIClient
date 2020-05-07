package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor {
    @JsonProperty("id")
    private int id;
    @JsonProperty("stationId")
    private String stationId;
    @JsonProperty("param")
    private SensorParam param;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("stationId")
    public String getStationId() {
        return stationId;
    }

    @JsonProperty("stationId")
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    @JsonProperty("param")
    public SensorParam getParam() {
        return param;
    }

    @JsonProperty("param")
    public void setParam(SensorParam param) {
        this.param = param;
    }
}

//    "id": 92,
//    "stationId": 14,
//    "param": {
//      "paramName": "pył zawieszony PM10",
//      "paramFormula": "PM10",
//      "paramCode": "PM10",
//      "idParam": 3
//    }