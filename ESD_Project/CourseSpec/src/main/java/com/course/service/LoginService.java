package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.course.handles.ResourceNotFoundException;
import com.course.model.User;
import com.course.repo.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    // Method to validate user credentials
    public boolean authenticateUser(String username, String password) {
        // Fetch user by username from the database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));

        // Validate the provided password against the hashed password
        return passwordEncoder.matches(password, user.getPassword());
    }
}
