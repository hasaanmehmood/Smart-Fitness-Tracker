package com.fitness.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Main entry point for the Smart Fitness Tracker application.
 *
 * This application provides a comprehensive fitness tracking solution with:
 * - User authentication and authorization using JWT
 * - CRUD operations for workouts and exercises
 * - MongoDB for flexible data storage
 * - RESTful API design
 *
 * Architecture:
 * - Controller Layer: Handles HTTP requests and responses
 * - Service Layer: Contains business logic
 * - Repository Layer: Database operations
 * - Model Layer: Entity definitions
 *
 * @author Fitness Tracker Team
 * @version 1.0.0
 */
@SpringBootApplication
//@EnableMongoAuditing // Enables automatic timestamp management (createdDate, lastModifiedDate)
public class FitnessTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessTrackerApplication.class, args);
    }
}

/**
 * Git Command:
 * git init
 * git add pom.xml src/main/java/com/fitness/tracker/FitnessTrackerApplication.java
 * git commit -m "Initial project setup with Spring Boot and MongoDB"
 */