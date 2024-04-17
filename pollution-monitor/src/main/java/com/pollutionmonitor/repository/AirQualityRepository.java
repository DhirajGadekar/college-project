package com.pollutionmonitor.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pollutionmonitor.entity.AirQuality;
import com.pollutionmonitor.entity.AirQualityPerHour;

public interface AirQualityRepository extends JpaRepository<AirQuality, LocalDate>{

    @Query("SELECT aq.airQualityPerHourList FROM AirQuality aq WHERE localDate = :localDate")
    public Optional<List<AirQualityPerHour>> getAirQualityPerHourListByDate(@Param("localDate") LocalDate localDate);    
}