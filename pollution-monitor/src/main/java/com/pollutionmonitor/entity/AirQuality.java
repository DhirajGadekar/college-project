package com.pollutionmonitor.entity;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AirQuality {
    
    @Id
    private LocalDate localDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<AirQualityPerHour> airQualityPerHourList = new ArrayList<>();

    public AirQuality() {
    }

    public AirQuality(LocalDate localDate, List<AirQualityPerHour> airQualityPerHourList) {
        this.localDate = localDate;
        this.airQualityPerHourList = airQualityPerHourList;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<AirQualityPerHour> getAirQualityPerHourList() {
        return airQualityPerHourList;
    }

    public void setAirQualityPerHourList(List<AirQualityPerHour> airQualityPerHourList) {
        this.airQualityPerHourList = airQualityPerHourList;
    }

    @Override
    public String toString() {
        return "AirQuality [localDate=" + localDate + ", airQualityPerHourList=" + airQualityPerHourList + "]";
    }    
}
