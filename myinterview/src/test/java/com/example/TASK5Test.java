package com.example;


import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.example.model.Employee;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class TASK5Test {

    //Should be created a new Employee
    @Test
    public void testCreateEmployee() {
        String url = "http://localhost:8089/employees";
        Employee newEmployee = new Employee();
        newEmployee.setName("Renato");
        newEmployee.setLastName("Rodrigues");
        newEmployee.setOccupation("Developer");
        newEmployee.setBirthday(LocalDate.of(1990, 1, 1));
        newEmployee.setHiredDate(LocalDate.now());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, headers);

        // When
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.POST, entity, Employee.class);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newEmployee.getName(), Objects.requireNonNull(response.getBody()).getName());
    }

    //should be get first employee
    @Test
    public void testGetEmployee() {

        String createUrl = "http://localhost:8089/employees";
        Employee newEmployee = new Employee();
        newEmployee.setName("Renato");
        newEmployee.setLastName("Rodrigues");
        newEmployee.setOccupation("Developer");
        newEmployee.setBirthday(LocalDate.of(1990, 1, 1));
        newEmployee.setHiredDate(LocalDate.now());

        HttpHeaders createHeaders = new HttpHeaders();
        createHeaders.set("Content-Type", "application/json");
        HttpEntity<Employee> createEntity = new HttpEntity<>(newEmployee, createHeaders);

        RestTemplate createRestTemplate = new RestTemplate();
        ResponseEntity<Employee> createResponse = createRestTemplate.exchange(createUrl, HttpMethod.POST, createEntity, Employee.class);

        // Agora, obtenha o funcionário que acabamos de criar
        String getUrl = "http://localhost:8089/employees/" + Objects.requireNonNull(createResponse.getBody()).getId();
        HttpHeaders getHeaders = new HttpHeaders();
        HttpEntity<String> getEntity = new HttpEntity<>(getHeaders);

        RestTemplate getRestTemplate = new RestTemplate();
        ResponseEntity<Employee> getResponse = getRestTemplate.exchange(getUrl, HttpMethod.GET, getEntity, Employee.class);

        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(newEmployee.getName(), Objects.requireNonNull(getResponse.getBody()).getName());
    }

    //should be return all employees
    @Test
    public void testGetAllEmployees() {
        String url = "http://localhost:8089/employees";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    //should be update first employee
    @Test
    public void testUpdateEmployee() {
        String createUrl = "http://localhost:8089/employees";
        Employee newEmployee = new Employee();
        newEmployee.setName("Renato");
        newEmployee.setLastName("Rodrigues");
        newEmployee.setOccupation("Developer");
        newEmployee.setBirthday(LocalDate.of(1990, 1, 1));
        newEmployee.setHiredDate(LocalDate.now());

        HttpHeaders createHeaders = new HttpHeaders();
        createHeaders.set("Content-Type", "application/json");
        HttpEntity<Employee> createEntity = new HttpEntity<>(newEmployee, createHeaders);

        RestTemplate createRestTemplate = new RestTemplate();
        ResponseEntity<Employee> createResponse = createRestTemplate.exchange(createUrl, HttpMethod.POST, createEntity, Employee.class);

        String updateUrl = "http://localhost:8089/employees/" + createResponse.getBody().getId();
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName("Renato Updated");
        updatedEmployee.setLastName("Rodrigues Updated");
        updatedEmployee.setOccupation("Developer Updated");
        updatedEmployee.setBirthday(LocalDate.of(1990, 1, 1));
        updatedEmployee.setHiredDate(LocalDate.now());

        HttpHeaders updateHeaders = new HttpHeaders();
        updateHeaders.set("Content-Type", "application/json");
        HttpEntity<Employee> updateEntity = new HttpEntity<>(updatedEmployee, updateHeaders);

        RestTemplate updateRestTemplate = new RestTemplate();
        ResponseEntity<Employee> updateResponse = updateRestTemplate.exchange(updateUrl, HttpMethod.PUT, updateEntity, Employee.class);

        assertEquals(HttpStatus.OK, updateResponse.getStatusCode()); //should be return status code 200
        assertEquals(updatedEmployee.getName(), Objects.requireNonNull(updateResponse.getBody()).getName());
    }


    //should be deleted employee
    @Test
    public void testDeleteEmployee() {
        String createUrl = "http://localhost:8089/employees";
        Employee newEmployee = new Employee();
        newEmployee.setName("Renato");
        newEmployee.setLastName("Rodrigues");
        newEmployee.setOccupation("Developer");
        newEmployee.setBirthday(LocalDate.of(1990, 1, 1));
        newEmployee.setHiredDate(LocalDate.now());

        HttpHeaders createHeaders = new HttpHeaders();
        createHeaders.set("Content-Type", "application/json");
        HttpEntity<Employee> createEntity = new HttpEntity<>(newEmployee, createHeaders);

        RestTemplate createRestTemplate = new RestTemplate();
        ResponseEntity<Employee> createResponse = createRestTemplate.exchange(createUrl, HttpMethod.POST, createEntity, Employee.class);

        String deleteUrl = "http://localhost:8089/employees/" + createResponse.getBody().getId();
        HttpHeaders deleteHeaders = new HttpHeaders();
        HttpEntity<String> deleteEntity = new HttpEntity<>(deleteHeaders);

        RestTemplate deleteRestTemplate = new RestTemplate();
        ResponseEntity<String> deleteResponse = deleteRestTemplate.exchange(deleteUrl, HttpMethod.DELETE, deleteEntity, String.class);

        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode()); //should be return status code 204
    }
}