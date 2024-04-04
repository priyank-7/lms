## LMS - Learning Management System

This project implements a REST API for a Learning Management System (LMS) built with Java and Spring technologies.

### Tech Stack

* **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security, Java Validator API
* **Database:** MySQL
* **Authentication:** JWT (JSON Web Token)
* **Caching:** Redis

### Features

* User Authentication and Authorization with Spring Security
* Database operations using Spring Data JPA and MySQL
* Input validation with Java Validator API
* Data Transfer Objects (DTOs) for response optimization
* Caching with Redis for improved performance

**Optional - Add any additional features you've implemented**

### Getting Started

**Prerequisites:**

* Java 17
* Maven
* MySql Server

**Installation:**

1. Clone the repository:

```bash
git clone [https://github.com/](https://github.com/)<your-username>/LMS.git
cd LMS
mvn clean install
```

**Configuration:**

Before running the application, you'll need to configure your database connection and Redis settings.

Database Configuration: Update the <code>application.properties</code> file with MySQL connection details
Redis Cache Configuration (Optional): Update the <code>CacheConfig,java</code> file with Redis connection details: host, port

**Running the application:**

```bash
mvn spring-boot:run
```
The application will be running on port: 8080.
