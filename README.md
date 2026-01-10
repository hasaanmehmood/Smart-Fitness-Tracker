# 🏋️ Smart Fitness & Workout Tracker

A full-stack fitness tracking web application built with **Java Spring Boot** and **MongoDB**. Track your workouts, manage exercises, and monitor your fitness journey with JWT authentication, RESTful API, and comprehensive features.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-green)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Troubleshooting](#troubleshooting)

## ✨ Features

### Core Features
- ✅ **User Authentication** - JWT-based secure authentication
- ✅ **User Registration & Login** - Complete user management
- ✅ **Workout CRUD Operations** - Create, Read, Update, Delete workouts
- ✅ **Exercise Catalog** - Comprehensive exercise database
- ✅ **Search & Filter** - Find workouts by name, intensity, date range
- ✅ **File Upload** - Upload profile and exercise images
- ✅ **User Profiles** - Manage personal fitness information

### Technical Features
- 🔐 **JWT Authentication** - Stateless, token-based security
- 🗄️ **MongoDB Integration** - NoSQL database with flexible schema
- 📝 **Structured Logging** - Application logging with Logback
- 🧪 **Comprehensive Testing** - Unit and integration tests
- 🔒 **Security Best Practices** - BCrypt password hashing, CORS configuration
- 📊 **RESTful API Design** - Clean, standardized endpoints
- ⚠️ **Global Exception Handling** - Consistent error responses
- 🎯 **Role-Based Access Control** - User and Admin roles

## 🛠 Technology Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data MongoDB** - Database integration
- **JWT (JSON Web Tokens)** - Stateless authentication
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

### Database
- **MongoDB** - NoSQL document database

### Testing
- **JUnit 5** - Testing framework
- **Mockito** - Mocking framework
- **Spring Boot Test** - Integration testing
- **Embedded MongoDB** - Test database

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK) 17 or higher**
   ```bash
   java -version
   ```

2. **Apache Maven 3.6 or higher**
   ```bash
   mvn -version
   ```

3. **MongoDB 4.4 or higher** (Local or Atlas)
    - [Download MongoDB](https://www.mongodb.com/try/download/community)
    - Or use [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) (free tier available)

4. **IDE (Recommended)**
    - IntelliJ IDEA (Community or Ultimate)
    - Eclipse
    - VS Code with Java extensions

5. **Git**
   ```bash
   git --version
   ```

## 🚀 Installation & Setup

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd fitness-tracker
```

### Step 2: Install MongoDB

#### Option A: Local MongoDB
1. Download and install MongoDB from the [official website](https://www.mongodb.com/try/download/community)
2. Start MongoDB service:
   ```bash
   # Windows
   net start MongoDB
   
   # macOS (using Homebrew)
   brew services start mongodb-community
   
   # Linux
   sudo systemctl start mongod
   ```

#### Option B: MongoDB Atlas (Cloud)
1. Create a free account at [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
2. Create a new cluster
3. Get your connection string
4. Update `src/main/resources/application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/fitness_tracker
   ```

### Step 3: Configure Application

1. Open `src/main/resources/application.properties`
2. Update MongoDB connection:
   ```properties
   # For local MongoDB
   #spring.data.mongodb.uri=mongodb://localhost:27017/fitness_tracker
   
   # For MongoDB Atlas
   #spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/fitness_tracker
   ```

3. (Optional) Change JWT secret for production:
   ```properties
   app.jwt.secret=YOUR_SECURE_SECRET_KEY_HERE
   ```

### Step 4: Import Project in IDE

#### IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select `pom.xml`
3. Click "Open as Project"
4. Wait for Maven to download dependencies

#### Eclipse
1. Open Eclipse
2. File → Import → Maven → Existing Maven Projects
3. Select project directory
4. Click Finish

#### VS Code
1. Open VS Code
2. Install "Extension Pack for Java"
3. File → Open Folder → Select project directory
4. Trust the folder when prompted

### Step 5: Build the Project

```bash
# Clean and build
mvn clean install

# Build without running tests (faster)
mvn clean install -DskipTests
```

## ▶️ Running the Application

### Method 1: Using Maven

```bash
mvn spring-boot:run
```

### Method 2: Using IDE

**IntelliJ IDEA:**
1. Locate `FitnessTrackerApplication.java`
2. Right-click → Run 'FitnessTrackerApplication'

**Eclipse:**
1. Right-click on project
2. Run As → Spring Boot App

### Method 3: Using JAR File

```bash
# Build JAR
mvn clean package

# Run JAR
java -jar target/fitness-tracker-1.0.0.jar
```

### Verify Application Started

The application should start on `http://localhost:8080`

You should see:
```
Started FitnessTrackerApplication in X.XXX seconds
```

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication Endpoints

#### Register New User
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securePassword123",
  "fullName": "John Doe",
  "weight": 75.5,
  "height": 180.0,
  "fitnessGoal": "Muscle Gain"
}
```

**Response:**
```json
{
  "message": "User registered successfully"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "securePassword123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "id": "507f1f77bcf86cd799439011",
  "username": "john_doe",
  "email": "john@example.com",
  "roles": ["ROLE_USER"]
}
```

### Workout Endpoints (Requires Authentication)

#### Create Workout
```http
POST /api/workouts
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "name": "Morning Cardio",
  "description": "30-minute run",
  "workoutDate": "2024-01-15T08:00:00",
  "durationMinutes": 30,
  "caloriesBurned": 300,
  "intensity": "MEDIUM",
  "status": "COMPLETED",
  "exercises": [
    {
      "exerciseId": "507f1f77bcf86cd799439011",
      "exerciseName": "Running",
      "durationSeconds": 1800,
      "distance": 5.0,
      "orderIndex": 1
    }
  ]
}
```

#### Get All Workouts
```http
GET /api/workouts
Authorization: Bearer <JWT_TOKEN>
```

#### Get Workout by ID
```http
GET /api/workouts/{id}
Authorization: Bearer <JWT_TOKEN>
```

#### Update Workout
```http
PUT /api/workouts/{id}
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "name": "Updated Workout Name",
  ...
}
```

#### Delete Workout
```http
DELETE /api/workouts/{id}
Authorization: Bearer <JWT_TOKEN>
```

#### Search Workouts
```http
GET /api/workouts/search?q=cardio
Authorization: Bearer <JWT_TOKEN>
```

#### Filter by Intensity
```http
GET /api/workouts/filter/intensity?level=HIGH
Authorization: Bearer <JWT_TOKEN>
```

#### Filter by Date Range
```http
GET /api/workouts/date-range?start=2024-01-01T00:00:00&end=2024-01-31T23:59:59
Authorization: Bearer <JWT_TOKEN>
```

### Exercise Endpoints

#### Get All Exercises (Public)
```http
GET /api/exercises/public
```

#### Search Exercises (Public)
```http
GET /api/exercises/public/search?q=push
```

#### Filter by Category (Public)
```http
GET /api/exercises/public/category/STRENGTH
```

### User Profile Endpoints

#### Get Current User Profile
```http
GET /api/users/me
Authorization: Bearer <JWT_TOKEN>
```

#### Update Profile
```http
PUT /api/users/me
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "fullName": "John Updated",
  "weight": 76.0,
  "height": 181.0,
  "fitnessGoal": "Weight Loss"
}
```

#### Upload Profile Image
```http
POST /api/users/upload-profile-image
Authorization: Bearer <JWT_TOKEN>
Content-Type: multipart/form-data

file: <image_file>
```

## 🧪 Testing

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=AuthServiceTest
```

### Run Tests with Coverage
```bash
mvn clean test jacoco:report
```

### Test Coverage Report
After running tests with coverage, open:
```
target/site/jacoco/index.html
```

### Manual Testing with Postman

1. **Import Postman Collection** (if provided)
2. **Create Environment Variables:**
    - `base_url`: `http://localhost:8080`
    - `jwt_token`: (will be set after login)

3. **Test Flow:**
    - Register user
    - Login (save JWT token)
    - Create workout
    - Get all workouts
    - Update workout
    - Delete workout

## 📁 Structure

```
fitness-tracker/
├── src/
│   ├── main/
│   │   ├── java/com/fitness/tracker/
│   │   │   ├── config/              # Configuration classes
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── MongoConfig.java
│   │   │   │   └── CorsConfig.java
│   │   │   ├── controller/          # REST controllers
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── WorkoutController.java
│   │   │   │   ├── ExerciseController.java
│   │   │   │   └── UserController.java
│   │   │   ├── model/              # Entity models
│   │   │   │   ├── User.java
│   │   │   │   ├── Workout.java
│   │   │   │   ├── Exercise.java
│   │   │   │   └── WorkoutExercise.java
│   │   │   ├── repository/         # Data access layer
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── WorkoutRepository.java
│   │   │   │   └── ExerciseRepository.java
│   │   │   ├── service/            # Business logic
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── WorkoutService.java
│   │   │   │   ├── ExerciseService.java
│   │   │   │   └── FileStorageService.java
│   │   │   ├── dto/                # Data transfer objects
│   │   │   ├── security/           # Security components
│   │   │   │   ├── JwtUtils.java
│   │   │   │   ├── JwtAuthFilter.java
│   │   │   │   └── UserDetailsServiceImpl.java
│   │   │   ├── exception/          # Exception handling
│   │   │   └── FitnessTrackerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback-spring.xml
│   └── test/                       # Test files
│       └── java/com/fitness/tracker/
├── target/                         # Build output
├── logs/                           # Application logs
├── uploads/                        # Uploaded files
├── pom.xml                         # Maven configuration
├── README.md                       # This file
└── TROUBLESHOOTING.md             # Troubleshooting guide
```

## ⚙️ Configuration

### Application Profiles

#### Development Profile
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

#### Production Profile
```bash
java -jar target/fitness-tracker-1.0.0.jar --spring.profiles.active=prod
```

### Environment Variables (Production)

```bash
export MONGODB_URI=mongodb+srv://user:pass@cluster.mongodb.net/fitness_tracker
export JWT_SECRET=your_super_secure_secret_key
export UPLOAD_DIR=/var/app/uploads
```

### Docker Deployment (Optional)

Create `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/fitness-tracker-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build and run:
```bash
docker build -t fitness-tracker .
docker run -p 8080:8080 -e MONGODB_URI=<uri> fitness-tracker
```

## 🔧 Troubleshooting

See [TROUBLESHOOTING.md](TROUBLESHOOTING.md) for detailed troubleshooting guide.

### Quick Fixes

**Port 8080 already in use:**
```properties
server.port=8081
```

**MongoDB connection failed:**
- Verify MongoDB is running: `mongod --version`
- Check connection string in `application.properties`

**JWT token expired:**
- Increase token expiration in `application.properties`
- Login again to get new token

## 🤝 Contribute

1. Fork the repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request


## 👥 Authors

- **Hasaan Mehmood** 


---

