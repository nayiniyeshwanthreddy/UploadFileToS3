package com.yeshwanth.sparkProject;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3UploadService {
    
    private final S3Client s3Client;
    private final String bucketName;
    
    public S3UploadService(S3Client s3Client, 
                          @Value("${aws.s3.bucket-name}") String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }
    
    public void uploadFile(byte[] fileContent, String fileName) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();
        
        s3Client.putObject(putObjectRequest, 
                         RequestBody.fromBytes(fileContent));
    }
}
