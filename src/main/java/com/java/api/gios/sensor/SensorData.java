package com.java.api.gios.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class SensorData {
    @JsonProperty("key")
    private String key;
    @JsonProperty("values")
    private SensorDataValue[] values;

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("values")
    public SensorDataValue[] getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(SensorDataValue[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "key='" + key + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}

//    "key": "PM10",
//    "values": [
//      {
//        "date": "2017-03-28 11:00:00",
//        "value": 30.3018
//      },
//      {
//        "date": "2017-03-28 12:00:00",
//        "value": 27.5946
//      }
//     ]