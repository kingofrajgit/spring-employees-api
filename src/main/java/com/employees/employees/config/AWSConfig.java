package com.employees.employees.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AWSConfig {

	@Value("${AWS_ACCESS_KEY_ID}")
	private String awsId;

	@Value("${AWS_SECRET_ACCESS_KEY}")
	private String awsKey;

	@Bean
	public S3Client s3client() {
		AwsCredentials credentials = AwsBasicCredentials.create(awsId, awsKey);
		S3Client s3client = S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(credentials))
				.region(Region.AP_SOUTH_1).build();
		return s3client;
	}

	@Bean
	public S3Presigner s3Presigner() {
		AwsCredentials credentials = AwsBasicCredentials.create(awsId, awsKey);
		S3Presigner s3Presigner = S3Presigner.builder()
				.credentialsProvider(StaticCredentialsProvider.create(credentials)).region(Region.AP_SOUTH_1).build();
		return s3Presigner;
	}
}
