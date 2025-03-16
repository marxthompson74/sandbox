package com.sandbox.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Service
public class SandboxService {
    public String getMessage() {

        // Get current date & time
        LocalDateTime now = LocalDateTime.now();
        
        // Format date & time (e.g., "2024-03-14 15:30:45")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Message content
        String message = "Hello from Spring Boot!";

        // Return message with timestamp
        return formattedDateTime + " - " + message;
    }
}

