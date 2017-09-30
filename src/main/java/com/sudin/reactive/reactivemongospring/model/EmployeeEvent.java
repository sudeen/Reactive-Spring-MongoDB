package com.sudin.reactive.reactivemongospring.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeEvent {

    private Employee employee;
    private Date date;

}
