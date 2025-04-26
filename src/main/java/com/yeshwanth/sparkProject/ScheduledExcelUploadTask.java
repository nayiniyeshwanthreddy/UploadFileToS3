package com.yeshwanth.sparkProject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ScheduledExcelUploadTask {
    
    private final S3UploadService s3UploadService;
    
    public ScheduledExcelUploadTask(
                                 S3UploadService s3UploadService) {
        this.s3UploadService = s3UploadService;
    }
    
    @Scheduled(cron = "${app.scheduling.excel-upload.cron}")
    public void UploadExcelToS3() {
        try {
            // Load the CSV file from the resources/static folder
            String filePath = "src/main/resources/static/BankCustomer.csv";
            byte[] csvFile = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath));
            
            String fileName = "customer_data_" + LocalDateTime.now() + ".csv";
            // Upload to S3
            s3UploadService.uploadFile(csvFile, fileName);
            
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
}
