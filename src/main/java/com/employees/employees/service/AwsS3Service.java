package com.employees.employees.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;


@Service
public class AwsS3Service {

	private Logger logger = LoggerFactory.getLogger(AwsS3Service.class);
	@Autowired
	private S3Client s3;
	
	@Value("${S3_BUCKET_NAME}")
	private String bucketName;
	
	public String uploadFileContentAsFile(String keyName, MultipartFile file) {

		String url = null;
		try {
			PutObjectRequest request = PutObjectRequest.builder().bucket(bucketName).key(keyName).build();

			RequestBody body = RequestBody.fromBytes(file.getBytes());
//			RequestBody body = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
			PutObjectResponse response = s3.putObject(request, body);
			logger.debug("Upload File content as bytes:" + response);

			GetUrlRequest request2 = GetUrlRequest.builder().bucket(bucketName).key(keyName).build();
			url = s3.utilities().getUrl(request2).toExternalForm();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;

	}
}
