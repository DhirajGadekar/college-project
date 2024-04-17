package com.pollutionmonitor.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AirQualityPerHour {

    @Id
    private LocalTime time;

    private int airQuality;

    public AirQualityPerHour() {
    }

    public AirQualityPerHour(LocalTime time, int airQuality) {
        this.time = time;
        this.airQuality = airQuality;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(int airQuality) {
        this.airQuality = airQuality;
    }

    @Override
    public String toString() {
        return "AirQualityPerHour [time=" + time + ", airQuality=" + airQuality + "]";
    }
}
