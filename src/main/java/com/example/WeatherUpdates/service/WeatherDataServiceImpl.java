package com.example.WeatherUpdates.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private String api_url="https://openweathermap.org/";
	private String api_key="6a377fb194798a72c56f9119b5261d0a";
	
	@Override
	public String getWeatherData(String city) {
		
		RestTemplate rs=new RestTemplate();
		
		String url=String.format(api_url+"?q=%s&appid=%s",city,api_key);
		
		return rs.getForObject(url, String.class);
	}
	
	
	

}
