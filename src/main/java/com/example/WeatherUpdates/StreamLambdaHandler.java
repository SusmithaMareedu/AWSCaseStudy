package com.example.WeatherUpdates;

import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.WeatherUpdates.dto.WeatherDataDto;
import com.example.WeatherUpdates.service.WeatherDataServiceImpl;





    public class StreamLambdaHandler implements RequestHandler<Map<String, String>, APIGatewayProxyResponseEvent> {
    	private final WeatherDataServiceImpl weatherService = new WeatherDataServiceImpl();
        private final AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
        private final DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        @Override
        public APIGatewayProxyResponseEvent handleRequest(Map<String, String> event, Context context) {
        	APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        	 try {
                 String city = event.get("city");
                 if (city == null || city.isEmpty()) {
                     response.setStatusCode(400);
                     response.setBody("City parameter is missing");
                     return response;
                 }
     
                 String weatherData = weatherService.getWeatherData(city);
                 WeatherDataDto data = new WeatherDataDto();
                 String id = UUID.randomUUID().toString(); 
                 data.setCity(id);
                 data.setCity(city);
                 data.setData(weatherData);
                 mapper.save(data);
     
                 response.setStatusCode(200);
                 response.setBody(weatherData);
             } catch (Exception e) {
                 response.setStatusCode(500);
                 response.setBody("An error occurred: " + e.getMessage());
             }
             return response;
        }
    
    	}
    


