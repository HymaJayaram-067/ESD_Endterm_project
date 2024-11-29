package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.DatabaseService;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/api/load-tables")
    public ResponseEntity<String> loadTables() {
        try {
            databaseService.loadTables();
            return ResponseEntity.ok("Tables created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating tables: " + e.getMessage());
        }
    }
}
