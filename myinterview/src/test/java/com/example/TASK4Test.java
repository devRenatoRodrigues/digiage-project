package com.example;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import static org.junit.Assert.*;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


public class TASK4Test {


    @Test
    public void testDataProcessor() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = "["
                + "{\"emp_no\": 1001, \"first_name\": \"Georgie\", \"last_name\": \"faccello\", \"gender\": \"M\"},"
                + "{\"emp_no\": 1002, \"first_name\": \"John\", \"last_name\": \"Doe\", \"gender\": \"M\"},"
                + "{\"emp_no\": 1003, \"first_name\": \"Jane\", \"last_name\": \"Doe\", \"gender\": \"F\"},"
                + "{\"emp_no\": 1004, \"first_name\": \"Alice\", \"last_name\": \"Smith\", \"gender\": \"F\"},"
                + "{\"emp_no\": 1005, \"first_name\": \"Bob\", \"last_name\": \"Johnson\", \"gender\": \"M\"}"
                + "]";
        JsonNode inputData = mapper.readTree(jsonData);

        TASK4.DataProcessor dataProcessor = new TASK4.DataProcessor();
        Map<String, Integer> result = dataProcessor.processData(inputData);

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("M", 3);
        expectedResult.put("F", 2);

        assertEquals(expectedResult, result);
    }

}