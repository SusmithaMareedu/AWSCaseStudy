package com.example.WeatherUpdates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeatherUpdates.dto.WeatherDataDto;
import com.example.WeatherUpdates.repo.WeatherRepository;
import com.example.WeatherUpdates.service.WeatherDataService;

@RestController
@RequestMapping("/weather")
public class WeatherInfoController {
	
	@Autowired
	WeatherDataService weatherDataService;
	
	@Autowired
	WeatherRepository weatherRepository;
	
	
	@GetMapping("/{city}")
	public ResponseEntity<String> getWeatherData(@PathVariable String city){
		
		String weatherData = weatherDataService.getWeatherData(city);
		WeatherDataDto data = new WeatherDataDto();
        data.setCity(city);
        data.setData(weatherData);
        weatherRepository.save(data);
        return ResponseEntity.ok(weatherData);
		
	}

}
