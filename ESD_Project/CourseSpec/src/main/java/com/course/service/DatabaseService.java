package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void loadTables() {
        try {
            // Load the SQL script from resources
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db/migration/create_tables.sql"), StandardCharsets.UTF_8)
            );

            String sql = reader.lines().collect(Collectors.joining("\n"));
            // Execute the SQL script
            jdbcTemplate.execute(sql);

            System.out.println("Tables created successfully");

            // Optional: You can hash the password for the user here if you want to handle it dynamically
            String hashedPassword = passwordEncoder.encode("password123");
            insertSampleUser(hashedPassword);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while creating tables: " + e.getMessage());
        }
    }

    private void insertSampleUser(String hashedPassword) {
        String insertUserQuery = "INSERT INTO users (username, password) VALUES ('testuser', ?)";
        jdbcTemplate.update(insertUserQuery, hashedPassword);
        System.out.println("Sample user inserted with hashed password");
    }
}
