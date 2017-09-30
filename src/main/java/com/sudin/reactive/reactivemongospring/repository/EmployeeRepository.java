package com.sudin.reactive.reactivemongospring.repository;

import com.sudin.reactive.reactivemongospring.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
}
