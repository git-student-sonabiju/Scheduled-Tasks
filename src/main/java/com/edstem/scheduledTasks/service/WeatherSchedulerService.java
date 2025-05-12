package com.edstem.scheduledTasks.service;

import com.edstem.scheduledTasks.model.WeatherAlert;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherSchedulerService {
	private final MockWeatherService mockWeatherService;
	private final WeatherAlertService weatherAlertService;

	public WeatherSchedulerService(MockWeatherService mockWeatherService, WeatherAlertService weatherAlertService) {
		this.mockWeatherService = mockWeatherService;
		this.weatherAlertService = weatherAlertService;
	}

	@Scheduled(fixedRate = 1800000)
	public void fetchWeather() {
		try {
			List<WeatherAlert> alerts = mockWeatherService.fetchMockData();
			weatherAlertService.saveAlerts(alerts);
		} catch (Exception e) {
			System.err.println("weather fetch failed: " + e.getMessage());
		}
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void purgeOldAlerts() {
		try {
			weatherAlertService.purgeOldAlerts();
		} catch (Exception e) {
			System.err.println("Alert purge failed: " + e.getMessage());
		}
	}
}
