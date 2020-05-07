package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SensorDataValue {
    @JsonProperty("date")
    private Date date;
    @JsonProperty("value")
    private Float value;

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("value")
    public Float getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorDataValue{" +
                "date=" + date +
                ", value=" + value +
                '}';
    }
}

//        "date": "2017-03-28 11:00:00",
//         "value": 30.3018