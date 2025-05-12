package com.edstem.scheduledTasks.service;

import com.edstem.scheduledTasks.dto.WeatherAlertDTO;
import com.edstem.scheduledTasks.model.WeatherAlert;
import com.edstem.scheduledTasks.repository.WeatherAlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherAlertService {
	private final WeatherAlertRepository weatherAlertRepository;

	public WeatherAlertService(WeatherAlertRepository weatherAlertRepository) {
		this.weatherAlertRepository = weatherAlertRepository;
	}

	public void saveAlerts(List<WeatherAlert> alerts) {
		weatherAlertRepository.saveAll(alerts);
	}

	public List<WeatherAlertDTO> getCurrentAlerts() {
		LocalDateTime cutOff = LocalDateTime.now().minusHours(1);
		return weatherAlertRepository.findByTimeStampAfter(cutOff).stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	public void purgeOldAlerts() {
		LocalDateTime cutOff = LocalDateTime.now().minusDays(1);
		weatherAlertRepository.deleteByTimeStampBefore(cutOff);
	}

	private WeatherAlertDTO toDTO(WeatherAlert alert) {
		return new WeatherAlertDTO(alert.getLocation(), alert.getTemperature(), alert.getHumidity(), alert.getAlertLevel(), alert.getTimeStamp());
	}

}
