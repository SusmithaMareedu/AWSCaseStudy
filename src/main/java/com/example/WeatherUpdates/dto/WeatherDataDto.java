package com.example.WeatherUpdates.dto;

public class WeatherDataDto {
	
	
private String id;
	
	private String city;
	
	private String data;
	
	public WeatherDataDto() {}
	
	

	public WeatherDataDto(String id, String city, String data) {
		super();
		this.id = id;
		this.city = city;
		this.data = data;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
