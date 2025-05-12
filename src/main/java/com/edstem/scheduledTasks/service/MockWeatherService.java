package com.edstem.scheduledTasks.service;

import com.edstem.scheduledTasks.model.WeatherAlert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockWeatherService {
	private static final String[] LOCATIONS = {"Chennai", "Delhi", "Mumbai"};
	private final Random random = new Random();

	public List<WeatherAlert> fetchMockData() {
		List<WeatherAlert> alerts = new ArrayList<>();
		for (String locations : LOCATIONS) {
			WeatherAlert alert = new WeatherAlert();
			alert.setLocation(locations);
			alert.setHumidity(30 + random.nextDouble() * 70); //30-100%
			double temp = 30 + random.nextDouble() * 15; //30–45°C
			alert.setTemperature(temp);
			alert.setTimeStamp(LocalDateTime.now());
			alert.setAlertLevel(temp > 40 ? "HIGH" : temp > 30 ? "MODERATE" : "LOW");
			alerts.add(alert);
		}
		return alerts;
	}
}
