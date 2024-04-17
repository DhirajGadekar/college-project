package com.pollutionmonitor.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pollutionmonitor.entity.AirQuality;
import com.pollutionmonitor.entity.AirQualityPerHour;
import com.pollutionmonitor.exception.AirQuantityNoFoundForDate;
import com.pollutionmonitor.repository.AirQualityRepository;

@Service
public class AirQualityServiceImpl implements AirQualityService {

    @Autowired
    private AirQualityRepository airQualityRepository;

    @Override
    public AirQualityPerHour addAirQuality(int aq) {

        AirQuality airQuality = airQualityRepository.findById(LocalDate.now()).orElse(null);

        if (airQuality == null) {

            airQuality = new AirQuality();
            airQuality.setLocalDate(LocalDate.now());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(formatter));

        AirQualityPerHour airQualityPerHour = new AirQualityPerHour();
        airQualityPerHour.setTime(currentTime);
        airQualityPerHour.setAirQuality(aq);

        List<AirQualityPerHour> airQualityPerHourList = airQuality.getAirQualityPerHourList();
        airQualityPerHourList.add(airQualityPerHour);

        airQuality.setAirQualityPerHourList(airQualityPerHourList);

        airQualityRepository.save(airQuality);
        return airQualityPerHour;
    }

    @Override
    public AirQuality getAirQualityByDate(LocalDate localDate) throws AirQuantityNoFoundForDate {

        Optional<AirQuality> airQuality = airQualityRepository.findById(LocalDate.now());

        if (airQuality.isPresent()) {

            return airQuality.get();
        }
        throw new AirQuantityNoFoundForDate("AirQuality Not Found for Date : " + LocalDate.now());
    }

    @Override
    public List<AirQualityPerHour> getAirQualityPerHourListByDate(LocalDate localDate)
            throws AirQuantityNoFoundForDate {
        Optional<List<AirQualityPerHour>> airQualityPerHourListByDate = airQualityRepository.getAirQualityPerHourListByDate(localDate);
        if (airQualityPerHourListByDate.isPresent()) {
            return airQualityPerHourListByDate.get();
        }
        throw new AirQuantityNoFoundForDate("AirQaulity not found at Date : " + localDate);
    }

}
