package com.edstem.scheduledTasks.controller;

import com.edstem.scheduledTasks.dto.WeatherAlertDTO;
import com.edstem.scheduledTasks.service.WeatherAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class WeatherAlertController {
	private final WeatherAlertService weatherAlertService;

	public WeatherAlertController(WeatherAlertService weatherAlertService) {
		this.weatherAlertService = weatherAlertService;
	}

	@GetMapping("/current")
	public List<WeatherAlertDTO> getCurrentAlerts()
	{
		return weatherAlertService.getCurrentAlerts();
	}

}
