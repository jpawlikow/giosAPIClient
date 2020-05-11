package com.java.api.gios.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQualityIndexLevel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("indexLevelName")
    private String indexLevelName;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("indexLevelName")
    public String getIndexLevelName() {
        return indexLevelName;
    }

    @JsonProperty("indexLevelName")
    public void setIndexLevelName(String indexLevelName) {
        this.indexLevelName = indexLevelName;
    }

    @Override
    public String toString() {
        return "AirQualityIndexLevel{" +
                "id=" + id +
                ", indexLevelName='" + indexLevelName + '\'' +
                '}';
    }
}
