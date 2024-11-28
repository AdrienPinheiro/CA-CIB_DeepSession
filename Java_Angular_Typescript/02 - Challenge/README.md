# Challenge README

This challenge is designed to help you understand and resolve issues in both the back-end and front-end parts of the project using GitHub Copilot. The goal is to ensure that the application works correctly, passes all tests, and meets the specified requirements. The `Resolved` folder is provided as a reference to support you in this challenge.

---

## Table of Contents

1. [Objective](#objective)
2. [Context](#context)
3. [Structure](#structure)
   - [Back-end](#back-end)
   - [Front-end](#front-end)
4. [Tasks](#tasks)
   - [Back-end Tasks](#back-end-tasks)
   - [Front-end Tasks](#front-end-tasks)
   - [Optional Enhancements](#optional-enhancements)
5. [Setup Instructions](#setup-instructions)
   - [Back-end Setup](#back-end-setup)
   - [Front-end Setup](#front-end-setup)
6. [Testing](#testing)
7. [Conclusion](#conclusion)

---

## Objective

The objective of this challenge is to:

- Build a complete RESTful API for managing movies (**back-end**).
- Create a user interface for interacting with the API (**front-end**).
- Ensure that all tests pass, the application builds successfully, and meets the specified requirements.
- Optionally, add advanced features like search, error handling, documentation, Docker support, and CI/CD pipelines to enhance the project.

---

## Context

The project is divided into two main parts:

- **Back-end**: A Spring Boot application for managing movies via a REST API.
- **Front-end**: An Angular application providing a user-friendly interface for interacting with the API.

---

## Structure

### Back-end

The back-end is a Spring Boot application with the following structure:

back/ 
├── src/ 
│ ├── main/ 
│ │ ├── java/ 
│ │ │ └── com.example.movies/ # Business logic and controllers 
│ │ ├── resources/ 
│ │ │ └── application.properties # Configuration files 
│ │ └── static/ # Optional static files 
│ └── test/ 
│ └── java/ # Unit and integration tests 
├── pom.xml # Maven configuration file 
└── mvnw, mvnw.cmd # Maven wrapper scripts


### Front-end

The front-end is an Angular application with the following structure:

front/ 
├── .vscode/ # VSCode settings 
├── src/ 
│ ├── app/ # Angular components, services, and modules 
│ ├── assets/ # Static assets 
│ ├── environments/ # Environment-specific configurations 
│ ├── index.html # Main HTML file 
│ ├── main.ts # Application entry point 
│ ├── styles.scss # Global styles 
│ └── tests/ # Test configurations 
├── angular.json # Angular project configuration 
├── package.json # NPM dependencies and scripts 
├── tsconfig.json # TypeScript configuration 
└── tsconfig.spec.json # TypeScript configuration for tests

---

## Tasks

### Back-end Tasks

1. **Build the REST API**:
   - Use an in-memory database (e.g., H2) for quick development.
   - Implement CRUD endpoints for managing movies.
   - Add error handling, optimize the code, and ensure the application is secure.

2. **Run and Test the Application**:
   - Build the back-end project using Maven:
   - Start the Spring Boot application:
   - Ensure all tests in `back/src/test/java` pass:
     - Examples: `CaCibApplicationTests`, `MovieTest`.

3. **Optional Enhancements**:
   - Add additional endpoints (e.g., advanced search, batch updates).
   - Use `@ControllerAdvice` for centralized error handling.
   - Generate API documentation using Swagger.

### Front-end Tasks

1. **Create the UI for CRUD**:
   - Build a user interface in Angular for interacting with the REST API.
   - Use forms to allow adding, editing, and deleting movies.

2. **Run and Test the Application**:
   - Install dependencies using NPM:
     npm install
   - Start the development server:
     ng serve
   - Ensure all tests in `front/src/app` pass (e.g., `app.component.spec.ts`).

3. **Optional Enhancements**:
   - Add search and filter functionalities to the movie list.
   - Create a responsive design for better user experience.

---

## Optional Enhancements

1. **Create a Dockerfile**:
   - Package the back-end and front-end applications into Docker containers.
   - Example for Spring Boot:
        ```Dockerfile
        FROM openjdk:17-jdk-slim
        COPY target/movie-api.jar movie-api.jar
        ENTRYPOINT ["java", "-jar", "movie-api.jar"]
        EXPOSE 8080
        ```

2. **Set Up CI/CD**:
   - Create a GitLab CI/CD pipeline for automating builds, tests, and deployments.
   - Example `.gitlab-ci.yml`:
        ```yaml
        stages:
        - build
        - test
        - deploy

        build:
        script:
            - mvn clean install
            - docker build -t movie-api .

        test:
        script:
            - mvn test

        deploy:
        script:
            - docker run -d -p 8080:8080 movie-api
        ```

3. **Generate Visual Documentation**:
   - Use Mermaid diagrams to represent workflows or architecture:
        ```mermaid
        graph TD
        A[User] -->|Interacts| B[Front-end]
        B -->|Requests| C[Back-end API]
        C -->|Stores| D[In-memory DB]
        ```

4. **Automation**:
   - Create a PowerShell script for setting up and running the project end-to-end.

---

## Setup Instructions

### Back-end Setup

1. Navigate to the `back` folder:

cd back

2. Build and run the back-end:

./mvnw clean install
./mvnw spring-boot:run

### Front-end Setup

1. Navigate to the front folder:

cd front

2. Install dependencies:

npm install

3. Start the development server:

ng serve

### Testing

Back-end Testing
1. Run back-end tests:

./mvnw test

Front-end Testing
Run front-end tests:

ng test


# Conclusion
By completing these tasks using GitHub Copilot, you will ensure that both the back-end and front-end parts of the project are functional, secure, and optimized. Use the Resolved folder as a reference to guide your progress.

Good luck! 🚀