package com.sudin.reactive.reactivemongospring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Employee {

    @Id
    private String id;
    private String name;
    private Long Salary;
}
