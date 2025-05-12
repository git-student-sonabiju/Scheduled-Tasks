package com.edstem.scheduledTasks.repository;

import com.edstem.scheduledTasks.model.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {
	List<WeatherAlert> findByTimeStampAfter(LocalDateTime cutOff);

	void deleteByTimeStampBefore(LocalDateTime cutOff);
}
