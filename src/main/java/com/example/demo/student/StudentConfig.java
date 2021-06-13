package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student tomer = new Student(
                    "Tomer",
                    "email@email.com",
                    LocalDate.of(1993, Month.DECEMBER,4)
            );
            Student shira = new Student(
                    "Shira",
                    "email@email.com",
                    LocalDate.of(1993, Month.SEPTEMBER,5)
            );

            repository.saveAll(
                    List.of(tomer, shira)
            );
        };
    }
}
