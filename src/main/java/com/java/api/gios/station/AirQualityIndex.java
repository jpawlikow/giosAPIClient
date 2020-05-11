package com.java.api.gios.station;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.api.gios.Util;

import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirQualityIndex {
    @JsonProperty("id")
    private int id;
    @JsonProperty("stCalcDate")
    private Date stCalcDate;
    @JsonProperty("stIndexLevel")
    private AirQualityIndexLevel stIndexLevel;
    @JsonProperty("stSourceDataDate")
    private Date stSourceDataDate;
    @JsonProperty("stIndexStatus")
    private boolean stIndexStatus;
    @JsonProperty("stIndexCrParam")
    private String stIndexCrParam;

    @JsonProperty("so2CalcDate")
    private Date so2CalcDate;
    @JsonProperty("so2IndexLevel")
    private AirQualityIndexLevel so2IndexLevel;
    @JsonProperty("so2SourceDataDate")
    private Date so2SourceDataDate;

    @JsonProperty("no2CalcDate")
    private Date no2CalcDate;
    @JsonProperty("no2IndexLevel")
    private AirQualityIndexLevel no2IndexLevel;
    @JsonProperty("no2SourceDataDate")
    private Date no2SourceDataDate;

    @JsonProperty("coCalcDate")
    private Date coCalcDate;
    @JsonProperty("coIndexLevel")
    private AirQualityIndexLevel coIndexLevel;
    @JsonProperty("coSourceDataDate")
    private Date coSourceDataDate;

    @JsonProperty("pm10CalcDate")
    private Date pm10CalcDate;
    @JsonProperty("pm10IndexLevel")
    private AirQualityIndexLevel pm10IndexLevel;
    @JsonProperty("pm10SourceDataDate")
    private Date pm10SourceDataDate;

    @JsonProperty("pm25CalcDate")
    private Date pm25CalcDate;
    @JsonProperty("pm25IndexLevel")
    private AirQualityIndexLevel pm25IndexLevel;
    @JsonProperty("pm25SourceDataDate")
    private Date pm25SourceDataDate;

    @JsonProperty("o3CalcDate")
    private Date o3CalcDate;
    @JsonProperty("o3IndexLevel")
    private AirQualityIndexLevel o3IndexLevel;
    @JsonProperty("o3SourceDataDate")
    private Date o3SourceDataDate;

    @JsonProperty("c6h6CalcDate")
    private Date c6h6CalcDate;
    @JsonProperty("c6h6IndexLevel")
    private AirQualityIndexLevel c6h6IndexLevel;
    @JsonProperty("c6h6SourceDataDate")
    private Date c6h6SourceDataDate;


    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("stCalcDate")
    public Date getStCalcDate() {
        return stCalcDate;
    }

    @JsonProperty("stCalcDate")
    public void setStCalcDate(String date) {
        this.stCalcDate = Util.parseDate(date);
    }

    @JsonProperty("stIndexLevel")
    public AirQualityIndexLevel getStIndexLevel() {
        return stIndexLevel;
    }

    @JsonProperty("stIndexLevel")
    public void setStIndexLevel(AirQualityIndexLevel stIndexLevel) {
        this.stIndexLevel = stIndexLevel;
    }

    @JsonProperty("stSourceDataDate")
    public Date getStSourceDataDate() {
        return stSourceDataDate;
    }

    @JsonProperty("stSourceDataDate")
    public void setStSourceDataDate(String date) {
        this.stSourceDataDate = Util.parseDate(date);
    }

    public boolean isStIndexStatus() {
        return stIndexStatus;
    }

    public void setStIndexStatus(boolean stIndexStatus) {
        this.stIndexStatus = stIndexStatus;
    }

    public String getStIndexCrParam() {
        return stIndexCrParam;
    }

    public void setStIndexCrParam(String stIndexCrParam) {
        this.stIndexCrParam = stIndexCrParam;
    }

    @JsonProperty("so2CalcDate")
    public Date getSo2CalcDate() {
        return so2CalcDate;
    }

    @JsonProperty("so2CalcDate")
    public void setSo2CalcDate(String date) {
        this.so2CalcDate = Util.parseDate(date);
    }

    @JsonProperty("so2IndexLevel")
    public AirQualityIndexLevel getSo2IndexLevel() {
        return so2IndexLevel;
    }

    @JsonProperty("so2IndexLevel")
    public void setSo2IndexLevel(AirQualityIndexLevel so2IndexLevel) {
        this.so2IndexLevel = so2IndexLevel;
    }

    @JsonProperty("so2SourceDataDate")
    public Date getSo2SourceDataDate() {
        return so2SourceDataDate;
    }

    @JsonProperty("so2SourceDataDate")
    public void setSo2SourceDataDate(String date) {
        this.so2SourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("no2CalcDate")
    public Date getNo2CalcDate() {
        return no2CalcDate;
    }

    @JsonProperty("no2CalcDate")
    public void setNo2CalcDate(String date) {
        this.no2CalcDate = Util.parseDate(date);
    }

    @JsonProperty("no2IndexLevel")
    public AirQualityIndexLevel getNo2IndexLevel() {
        return no2IndexLevel;
    }

    @JsonProperty("no2IndexLevel")
    public void setNo2IndexLevel(AirQualityIndexLevel no2IndexLevel) {
        this.no2IndexLevel = no2IndexLevel;
    }

    @JsonProperty("no2SourceDataDate")
    public Date getNo2SourceDataDate() {
        return no2SourceDataDate;
    }

    @JsonProperty("no2SourceDataDate")
    public void setNo2SourceDataDate(String date) {
        this.no2SourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("coCalcDate")
    public Date getCoCalcDate() {
        return coCalcDate;
    }

    @JsonProperty("coCalcDate")
    public void setCoCalcDate(String date) {
        this.coCalcDate = Util.parseDate(date);
    }

    @JsonProperty("coIndexLevel")
    public AirQualityIndexLevel getCoIndexLevel() {
        return coIndexLevel;
    }

    @JsonProperty("coIndexLevel")
    public void setCoIndexLevel(AirQualityIndexLevel coIndexLevel) {
        this.coIndexLevel = coIndexLevel;
    }

    @JsonProperty("coSourceDataDate")
    public Date getCoSourceDataDate() {
        return coSourceDataDate;
    }

    @JsonProperty("coSourceDataDate")
    public void setCoSourceDataDate(String date) {
        this.coSourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("pm10CalcDate")
    public Date getPm10CalcDate() {
        return pm10CalcDate;
    }

    @JsonProperty("pm10CalcDate")
    public void setPm10CalcDate(String date) {
        this.pm10CalcDate = Util.parseDate(date);
    }

    @JsonProperty("pm10IndexLevel")
    public AirQualityIndexLevel getPm10IndexLevel() {
        return pm10IndexLevel;
    }

    @JsonProperty("pm10IndexLevel")
    public void setPm10IndexLevel(AirQualityIndexLevel pm10IndexLevel) {
        this.pm10IndexLevel = pm10IndexLevel;
    }

    @JsonProperty("pm10SourceDataDate")
    public Date getPm10SourceDataDate() {
        return pm10SourceDataDate;
    }

    @JsonProperty("pm10SourceDataDate")
    public void setPm10SourceDataDate(String date) {
        this.pm10SourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("pm25CalcDate")
    public Date getPm25CalcDate() {
        return pm25CalcDate;
    }

    @JsonProperty("pm25CalcDate")
    public void setPm25CalcDate(String date) {
        this.pm25CalcDate = Util.parseDate(date);
    }

    @JsonProperty("pm25IndexLevel")
    public AirQualityIndexLevel getPm25IndexLevel() {
        return pm25IndexLevel;
    }

    @JsonProperty("pm25IndexLevel")
    public void setPm25IndexLevel(AirQualityIndexLevel pm25IndexLevel) {
        this.pm25IndexLevel = pm25IndexLevel;
    }

    @JsonProperty("pm25SourceDataDate")
    public Date getPm25SourceDataDate() {
        return pm25SourceDataDate;
    }

    @JsonProperty("pm25SourceDataDate")
    public void setPm25SourceDataDate(String date) {
        this.pm25SourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("o3CalcDate")
    public Date getO3CalcDate() {
        return o3CalcDate;
    }

    @JsonProperty("o3CalcDate")
    public void setO3CalcDate(String date) {
        this.o3CalcDate = Util.parseDate(date);
    }

    @JsonProperty("o3IndexLevel")
    public AirQualityIndexLevel getO3IndexLevel() {
        return o3IndexLevel;
    }

    @JsonProperty("o3IndexLevel")
    public void setO3IndexLevel(AirQualityIndexLevel o3IndexLevel) {
        this.o3IndexLevel = o3IndexLevel;
    }

    @JsonProperty("o3SourceDataDate")
    public Date getO3SourceDataDate() {
        return o3SourceDataDate;
    }

    @JsonProperty("o3SourceDataDate")
    public void setO3SourceDataDate(String date) {
        this.o3SourceDataDate = Util.parseDate(date);
    }

    @JsonProperty("c6h6CalcDate")
    public Date getC6h6CalcDate() {
        return c6h6CalcDate;
    }

    @JsonProperty("c6h6CalcDate")
    public void setC6h6CalcDate(String date) {
        this.c6h6CalcDate = Util.parseDate(date);
    }

    @JsonProperty("c6h6IndexLevel")
    public AirQualityIndexLevel getC6h6IndexLevel() {
        return c6h6IndexLevel;
    }

    @JsonProperty("c6h6IndexLevel")
    public void setC6h6IndexLevel(AirQualityIndexLevel c6h6IndexLevel) {
        this.c6h6IndexLevel = c6h6IndexLevel;
    }

    @JsonProperty("c6h6SourceDataDate")
    public Date getC6h6SourceDataDate() {
        return c6h6SourceDataDate;
    }

    @JsonProperty("c6h6SourceDataDate")
    public void setC6h6SourceDataDate(String date) {
        this.c6h6SourceDataDate = Util.parseDate(date);
    }

    @Override
    public String toString() {
        return "AirQualityIndex{" +
                "id=" + id +
                ", stCalcDate=" + stCalcDate +
                ", stIndexLevel=" + stIndexLevel +
                ", stSourceDataDate=" + stSourceDataDate +
                ", so2CalcDate=" + so2CalcDate +
                ", so2IndexLevel=" + so2IndexLevel +
                ", so2SourceDataDate=" + so2SourceDataDate +
                ", no2CalcDate=" + no2CalcDate +
                ", no2IndexLevel=" + no2IndexLevel +
                ", no2SourceDataDate=" + no2SourceDataDate +
                ", coCalcDate=" + coCalcDate +
                ", coIndexLevel=" + coIndexLevel +
                ", coSourceDataDate=" + coSourceDataDate +
                ", pm10CalcDate=" + pm10CalcDate +
                ", pm10IndexLevel=" + pm10IndexLevel +
                ", pm10SourceDataDate=" + pm10SourceDataDate +
                ", pm25CalcDate=" + pm25CalcDate +
                ", pm25IndexLevel=" + pm25IndexLevel +
                ", pm25SourceDataDate=" + pm25SourceDataDate +
                ", o3CalcDate=" + o3CalcDate +
                ", o3IndexLevel=" + o3IndexLevel +
                ", o3SourceDataDate=" + o3SourceDataDate +
                ", c6h6CalcDate=" + c6h6CalcDate +
                ", c6h6IndexLevel=" + c6h6IndexLevel +
                ", c6h6SourceDataDate=" + c6h6SourceDataDate +
                '}';
    }
}

//    "id": 52,
//    "stCalcDate": "2017-03-28 12:00:00",
//    "stIndexLevel": {
//    "id": 2,
//    "indexLevelName": "Umiarkowany"
//    },
//    "stSourceDataDate": "2017-03-28 12:00:00",
//    "so2CalcDate": "2017-03-28 12:00:00",
//    "so2IndexLevel": null,
//    "so2SourceDataDate": "2017-03-28 12:00:00",
//    "no2CalcDate": "2017-03-28 12:00:00",
//    "no2IndexLevel": null,
//    "no2SourceDataDate": "2017-03-28 12:00:00",
//    "coCalcDate": "2017-03-28 12:00:00",
//    "coIndexLevel": null,
//    "coSourceDataDate": "2017-03-28 12:00:00",
//    "pm10CalcDate": "2017-03-28 12:00:00",
//    "pm10IndexLevel": null,
//    "pm10SourceDataDate": "2017-03-28 12:00:00",
//    "pm25CalcDate": "2017-03-28 12:00:00",
//    "pm25IndexLevel": null,
//    "pm25SourceDataDate": null,
//    "o3CalcDate": "2017-03-28 12:00:00",
//    "o3IndexLevel": null,
//    "o3SourceDataDate": "2017-03-28 12:00:00",
//    "c6h6CalcDate": "2017-03-28 12:00:00",
//    "c6h6IndexLevel": null,
//    "c6h6SourceDataDate": "2017-03-28 12:00:00"