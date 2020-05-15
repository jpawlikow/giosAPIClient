package com.java.api.gios.station;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "stationName", "gegrLat", "gegrLon", "city", "addressStreet" })
public class Station {
    @JsonProperty("id")
    private int id;
    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("gegrLat")
    private double gegrLat;
    @JsonProperty("gegrLon")
    private double gegrLon;
    @JsonProperty("city")
    private City city;
    @JsonProperty("addressStreet")
    private String addressStreet;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("stationName")
    public String getStationName() {
        return stationName;
    }

    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("gegrLat")
    public double getGegrLat() {
        return gegrLat;
    }

    @JsonProperty("gegrLat")
    public void setGegrLat(double gegrLat) {
        this.gegrLat = gegrLat;
    }

    @JsonProperty("gegrLon")
    public double getGegrLon() {
        return gegrLon;
    }

    @JsonProperty("gegrLon")
    public void setGegrLon(double gegrLon) {
        this.gegrLon = gegrLon;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("addressStreet")
    public String getAddressStreet() {
        return addressStreet;
    }

    @JsonProperty("addressStreet")
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                '}';
    }

    //    [{
//        "id": 14,
//                "stationName": "Działoszyn",
//                "gegrLat": "50.972167",
//                "gegrLon": "14.941319",
//                "city": {
//            "id": 192,
//                    "name": "Działoszyn",
//                    "commune": {
//                "communeName": "Bogatynia",
//                        "districtName": "zgorzelecki",
//                        "provinceName": "DOLNOŚLĄSKIE"
//            }
//        },
//        "addressStreet": null
//    }]
}