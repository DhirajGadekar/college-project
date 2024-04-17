package com.pollutionmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PollutionMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollutionMonitorApplication.class, args);
	}
}
