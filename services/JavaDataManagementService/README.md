### **JavaDataManagementService**

#### Description

The `JavaDataManagementService` is a RESTful API developed using **Spring Boot** for managing user and item data. It provides CRUD operations for users and items, such as creating, updating, retrieving, and deleting entities from a PostgreSQL database. This service leverages Spring JDBC for database interaction and exposes endpoints for easy data management.

#### Key Features

- User and Item management (CRUD operations)
- REST API built with **Spring Boot**
- Integration with **PostgreSQL** database
- Dockerized for containerized deployments
- Spring Security with JWT
- Role-Based access control implementing public and admin endpoints

#### Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Security
- Spring JDBC
- PostgreSQL
- Docker

#### Getting Started

To run the service locally:

1. Build the project using Maven:
   ```bash
   ./mvnw clean install
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Build the Docker image:
   ```bash
   docker build -t javadatamanagementservice .
   ```

Use /swagger-ui/index.html for automatic API documentation
