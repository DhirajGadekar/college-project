package com.pollutionmonitor.service;

import java.time.LocalDate;
import java.util.List;

import com.pollutionmonitor.entity.AirQuality;
import com.pollutionmonitor.entity.AirQualityPerHour;
import com.pollutionmonitor.exception.AirQuantityNoFoundForDate;

public interface AirQualityService {
    
    public AirQualityPerHour addAirQuality(int airQuality);

    public AirQuality getAirQualityByDate(LocalDate localDate) throws AirQuantityNoFoundForDate;

    public List<AirQualityPerHour> getAirQualityPerHourListByDate(LocalDate localDate) throws AirQuantityNoFoundForDate;
}
