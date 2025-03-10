package com.kyungbae.section05.open_api;

public class AirDto {

    private String stationName;
    private double co;
    private Object o3;
    private Object pm10;

    public AirDto(){}

    public AirDto(String stationName, double co, Object o3, Object pm10) {
        this.stationName = stationName;
        this.co = co;
        this.o3 = o3;
        this.pm10 = pm10;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public Object getO3() {
        return o3;
    }

    public void setO3(Object o3) {
        this.o3 = o3;
    }

    public Object getPm10() {
        return pm10;
    }

    public void setPm10(Object pm10) {
        this.pm10 = pm10;
    }

    @Override
    public String toString() {
        return "AirDto{" +
                "stationName='" + stationName + '\'' +
                ", co=" + co +
                ", o3=" + o3 +
                ", pm10=" + pm10 +
                '}';
    }
}
