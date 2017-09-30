package com.sudin.reactive.reactivemongospring.controllers;

import com.sudin.reactive.reactivemongospring.model.Employee;
import com.sudin.reactive.reactivemongospring.model.EmployeeEvent;
import com.sudin.reactive.reactivemongospring.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Flux<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getId(@PathVariable final String empId) {
        return employeeRepository.findById(empId);
    }

    @GetMapping("/{id}/events")
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String empId) {
        return employeeRepository.findById(empId)
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
                    Flux<EmployeeEvent> employeeEventFlux =
                            Flux.fromStream(
                                    Stream.generate(() -> new EmployeeEvent(employee,
                                            new Date()))
                            );
                    return Flux.zip(interval, employeeEventFlux)
                            .map(Tuple2::getT2);
                });
    }

}
