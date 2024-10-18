package com.example.WeatherUpdates.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoConfig {

	/*
	 * @Value("${aws.access.key}") private String awsAccessKey;
	 * 
	 * @Value("${aws.access.secret-key}") private String awsSecretKey;
	 * 
	 * @Value("${aws.dynamodb.endpoint}") private String awsDynamoDbEndPoint;
	 * 
	 * 
	 * @Value("${aws.region}") private String awsRegion;
	 * 
	 * private AWSCredentialsProvider awsDynamoDBCredentials() { return new
	 * AWSStaticCredentialsProvider( new BasicAWSCredentials(awsAccessKey,
	 * awsSecretKey)); }
	 * 
	 * @Primary
	 * 
	 * @Bean public DynamoDBMapperConfig dynamoDBMapperConfig() { return
	 * DynamoDBMapperConfig.DEFAULT; }
	 * 
	 * @Bean
	 * 
	 * @Primary public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB,
	 * DynamoDBMapperConfig config) { return new DynamoDBMapper(amazonDynamoDB,
	 * config); }
	 * 
	 * @Bean public AmazonDynamoDB amazonDynamoDB() {
	 * 
	 * return AmazonDynamoDBClientBuilder.standard() .withEndpointConfiguration(new
	 * AwsClientBuilder.EndpointConfiguration(awsDynamoDbEndPoint, awsRegion))
	 * .withCredentials(awsDynamoDBCredentials()).build(); }
	 * 
	 */
	
	
	 @Value("${aws.dynamodb.endpoint}")
	    private String awsDynamoDBEndPoint;

	    @Bean
	    public AmazonDynamoDB amazonDynamoDB() {
	        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
	                .withCredentials(new InstanceProfileCredentialsProvider(false));

	        if (!awsDynamoDBEndPoint.isEmpty()) {
	            builder.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint, "us-east-1"));
	        }

	        return builder.build();
	    }

	    @Bean
	    public DynamoDBMapper mapper(){
	        return new DynamoDBMapper(amazonDynamoDB());
	    }


}
