package com.edstem.scheduledTasks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAlertDTO {
	private String location;
	private Double temperature;
	private Double humidity;
	private String alertLevel;
	private LocalDateTime timeStamp;
}
