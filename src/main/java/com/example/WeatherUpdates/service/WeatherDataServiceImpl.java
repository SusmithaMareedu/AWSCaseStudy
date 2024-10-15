package com.example.WeatherUpdates.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	 
	private String api_key="166139a7e3dc65981b80ed2374522956";
	 private String api_url="https://openweathermap.org/";
	@Override
	public String getWeatherData(String city) {
		
		RestTemplate rs=new RestTemplate();
		
		String url=String.format(api_url+"?q=%s&appid=%s",city,api_key);
		
		return rs.getForObject(url, String.class);
	}
	
	
	

}
