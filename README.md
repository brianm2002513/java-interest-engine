# Java Interest Engine 🚀

[![Java CI/CD Pipeline](https://github.com/brianm2002513/java-interest-engine/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/brianm2002513/java-interest-engine/actions/workflows/ci-cd.yml)

A professional-grade financial calculation engine built as a **Spring Boot REST API**.

## 🔄 CI/CD Pipeline
This project utilizes a multi-stage Maven pipeline to ensure enterprise reliability:
*   **Build**: Compiles the Spring Boot application and packages it into an executable JAR.
*   **Security Scan**: Leverages **GitHub CodeQL** to analyze the Java source code for security vulnerabilities.
*   **Unit Testing**: Executes a JUnit 5 test suite to verify the mathematical accuracy of the interest engine.
*   **Automated Release**: Automatically generates a GitHub Release with the compiled JAR file on every push to `master`.


## 🧠 Why this project stands out
This project demonstrates modern backend engineering skills, specifically mapped to enterprise Java environments:

1.  **Spring Boot Architecture**: Uses Spring Boot to provide a robust, production-ready REST API.
2.  **MVC & DTO Patterns**: Implements clear separation of concerns using Controllers, Services, and Data Transfer Objects (DTOs) for incoming/outgoing JSON.
3.  **Dependency Injection**: Leverages Spring's `@Service` and `@RestController` for clean, decoupled architecture.
4.  **Unit Testing (TDD)**: Comprehensive test suite using **JUnit 5** to ensure mathematical accuracy and handle edge cases (negative values, zero interest).

## 🛠 Tech Stack
*   **Language:** Java 17
*   **Framework:** Spring Boot 3
*   **Build Tool:** Maven
*   **Testing:** JUnit 5

## 🏗 Project Structure
```
src/
 ├── main/java/com/brian/interest/
 │    ├── controller/     <-- REST API Endpoints (Routing & JSON mapping)
 │    ├── dto/            <-- Data Transfer Objects (JSON shapes)
 │    ├── service/        <-- Core Business Logic
 │    └── InterestApplication.java  <-- Spring Boot Entry Point
 └── test/java/com/brian/interest/service/  <-- Unit Tests
```

## 🚀 How to Run

### Prerequisities
*   JDK 17 or higher
*   Maven

### Run Unit Tests
```bash
mvn clean test
```

### Start the API Server
```bash
mvn spring-boot:run
```
The server will start on `http://localhost:8080`.

## 🧪 Testing the API
Once the server is running, you can test the endpoint using `curl` or Postman.

**Endpoint:** `POST /api/interest/calculate`

**Request Payload (JSON):**
```json
{
  "principal": 1000,
  "rate": 5.0,
  "years": 2
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/api/interest/calculate \
     -H "Content-Type: application/json" \
     -d '{"principal": 1000, "rate": 5.0, "years": 2}'
```

**Expected Response:**
```json
{
  "principal": 1000.0,
  "simpleInterest": 100.0,
  "compoundInterest": 102.5,
  "finalBalance": 1102.5
}
```

---
*Created by Brian Munashe Mbawa as a demonstration of Spring Boot fundamentals.*
