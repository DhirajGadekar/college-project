package com.pollutionmonitor.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pollutionmonitor.service.FirebaseToMySQLService;

import java.util.concurrent.TimeUnit;

@Component
public class TaskSchedular {
    
    @Autowired
    private FirebaseToMySQLService firebaseToMySQLService;

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void putRealtimeDataInMySQL() {

        System.out.println("RealTime Data : ");
        firebaseToMySQLService.fetchDataAndStoreInMySQL();
    }
}
