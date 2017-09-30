package com.sudin.reactive.reactivemongospring;

import com.sudin.reactive.reactivemongospring.model.Employee;
import com.sudin.reactive.reactivemongospring.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveMongoSpringApplication {

    @Bean
    CommandLineRunner employees(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.deleteAll()
                    .subscribe(null, null, () -> {
                        Stream.of(new Employee(UUID.randomUUID().toString(),
                                "Sudin", 25000L), new Employee(UUID.randomUUID().toString(),
                                "sudeen", 23000L), new Employee(UUID.randomUUID().toString(),
                                "ranjit", 24000L), new Employee(UUID.randomUUID().toString(),
                                "ranjitkar", 21000L)
                        )
                                .forEach(employee -> {
                                    employeeRepository.save(employee)
                                            .subscribe(System.out::println);

                                });
                    });
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoSpringApplication.class, args);
    }


}
