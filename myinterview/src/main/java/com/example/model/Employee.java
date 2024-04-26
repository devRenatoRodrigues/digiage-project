package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String lastName;
    LocalDate birthday;
    LocalDate hiredDate;
    String occupation;
    Double salary;
}
