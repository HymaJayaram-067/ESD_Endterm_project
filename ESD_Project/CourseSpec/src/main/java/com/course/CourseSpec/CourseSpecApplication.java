package com.course.CourseSpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.course", "com.course.config"})
@EntityScan(basePackages = "com.course.model") 
@EnableJpaRepositories(basePackages = "com.course.repo") 
public class CourseSpecApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseSpecApplication.class, args);
    }
}
