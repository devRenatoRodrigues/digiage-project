package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> <a href="https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda">...</a>
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
    private static final String API_URL = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
    private static final String BUCKET_NAME = "interview-digiage";

    public static void main(String[] args) throws IOException {
        ApiClient apiClient = new ApiClient(API_URL);
        JsonNode root = apiClient.fetchData();

        DataProcessor dataProcessor = new DataProcessor();
        Map<String, Integer> genderCounts = dataProcessor.processData(root);

        FileSaver fileSaver = new FileSaver();
        Path filePath = fileSaver.saveData(genderCounts);

        Region region = Region.of("us-west-2");
        S3Uploader s3Uploader = new S3Uploader(BUCKET_NAME, region);
        s3Uploader.uploadFile(filePath);
    }

    public static class ApiClient {
        private final String apiUrl;

        ApiClient(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        JsonNode fetchData() throws IOException {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(apiUrl);

                try (CloseableHttpResponse response = client.execute(request)) {
                    if (response.getStatusLine().getStatusCode() != 200) {
                        throw new IOException("Unexpected code " + response.getStatusLine());
                    }

                    ObjectMapper mapper = new ObjectMapper();
                    String responseBody = EntityUtils.toString(response.getEntity());
                    return mapper.readTree(responseBody);
                }
            }
        }
    }

    public static class DataProcessor {
        Map<String, Integer> processData(JsonNode root) {
            Map<String, Integer> genderCounts = new HashMap<>();
            for (JsonNode node : root) {
                String gender = node.get("gender").asText();
                if ("M".equals(gender) || "F".equals(gender)) {
                    genderCounts.put(gender, genderCounts.getOrDefault(gender, 0) + 1);
                }
            }
            System.out.println(genderCounts);
            return genderCounts;
        }
    }

    public static class FileSaver {
        Path saveData(Map<String, Integer> data) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            Path filePath = Paths.get("genderCounts.txt");
            Files.write(filePath, mapper.writeValueAsBytes(data));
            return filePath;
        }
    }

    public static class S3Uploader {
        private final String bucketName;
        private final Region region;

        S3Uploader(String bucketName, Region region) {
            this.bucketName = bucketName;
            this.region = region;
        }

        void uploadFile(Path filePath) {
            try (S3Client s3 = S3Client.builder()
                    .region(region)
                    .build()) {

                PutObjectRequest putRequest = PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(filePath.getFileName().toString())
                        .build();

                PutObjectResponse putResponse = s3.putObject(putRequest, filePath);
                System.out.println("File uploaded to S3: " + putResponse.eTag());
            } catch (S3Exception e) {
                System.out.println("Error uploading file to S3: " + e.getMessage());
            }
        }
    }
}