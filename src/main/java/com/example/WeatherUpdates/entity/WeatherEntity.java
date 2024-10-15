package com.example.WeatherUpdates.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "WeatherData")


public class WeatherEntity {
	
	private String id;
	
	private String city;
	
	private String data;
	
	public WeatherEntity() {}
	
	

	public WeatherEntity(String id, String city, String data) {
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
