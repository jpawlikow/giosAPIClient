package com.java.api.gios.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorParam {
    @JsonProperty("paramName")
    private String paramName;
    @JsonProperty("paramFormula")
    private String paramFormula;
    @JsonProperty("paramCode")
    private String paramCode;
    @JsonProperty("idParam")
    private int idParam;

    @JsonProperty("paramName")
    public String getParamName() {
        return paramName;
    }

    @JsonProperty("paramName")
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @JsonProperty("paramFormula")
    public String getParamFormula() {
        return paramFormula;
    }

    @JsonProperty("paramFormula")
    public void setParamFormula(String paramFormula) {
        this.paramFormula = paramFormula;
    }

    @JsonProperty("paramCode")
    public String getParamCode() {
        return paramCode;
    }

    @JsonProperty("paramCode")
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    @JsonProperty("idParam")
    public int getIdParam() {
        return idParam;
    }

    @JsonProperty("idParam")
    public void setIdParam(int idParam) {
        this.idParam = idParam;
    }

    @Override
    public String toString() {
        return "SensorParam{" +
                "paramName='" + paramName + '\'' +
                ", paramFormula='" + paramFormula + '\'' +
                ", paramCode='" + paramCode + '\'' +
                ", idParam=" + idParam +
                '}';
    }
}

//        "paramName": "pył zawieszony PM10",
//        "paramFormula": "PM10",
//        "paramCode": "PM10",
//        "idParam": 3