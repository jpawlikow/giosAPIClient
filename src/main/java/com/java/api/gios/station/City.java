package com.java.api.gios.station;

import com.fasterxml.jackson.annotation.JsonProperty;


public class City {
    @JsonProperty("id")
    private int id;
    @JsonProperty("commune")
    private Commune commune;
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("commune")
    public Commune getCommune() {
        return commune;
    }

    @JsonProperty("commune")
    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", commune=" + commune.getCommuneName() +
                ", name='" + name + '\'' +
                '}';
    }
}


//            "id": 192,
//            "name": "Działoszyn",
//            "commune": {
//                "communeName": "Bogatynia",
//                 "districtName": "zgorzelecki",
//                 "provinceName": "DOLNOŚLĄSKIE"
//            }
