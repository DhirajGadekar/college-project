package com.pollutionmonitor.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pollutionmonitor.entity.AirQuality;
import com.pollutionmonitor.entity.AirQualityPerHour;
import com.pollutionmonitor.exception.AirQuantityNoFoundForDate;
import com.pollutionmonitor.service.AirQualityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;

    @GetMapping("/airquality/{date}")
    public ResponseEntity<AirQuality> getAirQuality(@PathVariable("date") LocalDate localDate)
            throws AirQuantityNoFoundForDate {

        return ResponseEntity.ok().body(airQualityService.getAirQualityByDate(localDate));
    }

    @GetMapping("/airqualitylist/{date}")
    public ResponseEntity<List<AirQualityPerHour>> getAirQualityListByDate(@PathVariable("date") LocalDate localDate)
            throws AirQuantityNoFoundForDate {

        return ResponseEntity.ok().body(airQualityService.getAirQualityPerHourListByDate(localDate));
    }

}
