package com.sotogito.section05.open_api;

public class AirDto {
    private String stationName;
    private double co;
    private double o3;
    private int mp10;

    public AirDto() {
    }

    public AirDto(String stationName, double co, double o3, int mp10) {
        this.stationName = stationName;
        this.co = co;
        this.o3 = o3;
        this.mp10 = mp10;
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

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public int getMp10() {
        return mp10;
    }

    public void setMp10(int mp10) {
        this.mp10 = mp10;
    }

    @Override
    public String toString() {
        return "AirDto{" +
                "stationName='" + stationName + '\'' +
                ", co=" + co +
                ", o3=" + o3 +
                ", mp10=" + mp10 +
                '}';
    }
}
