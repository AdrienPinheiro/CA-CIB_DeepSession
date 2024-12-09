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
   - [Extra challenge](#extra-challenge)
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

- **Back-end**: An MVC application for managing movies via a REST API.
- **Front-end**: An Angular application providing a user-friendly interface for interacting with the API.

---

## Setup Instructions

### Back-end Setup

1. Install dependencies you need :
```sh
dotnet add package Microsoft.EntityFrameworkCore.Sqlite
dotnet add package Microsoft.EntityFrameworkCore.Tools
dotnet tool install -global dotnet-ef
dotnet add package Microsoft.EntityFrameworkCore.Design
dotnet add package Moq
dotnet add package xunit
```

2. Clean and build the project with :
```sh
dotnet clean
dotnet build
```

2. Initialize the database :
```sh
dotnet ef migrations add InitialCreate
```

3. Then you can modify the file movies.db with your movies then update the database :
```sh
dotnet ef database update
```

4. Just go in the `back` folder and use:
```sh
dotnet run
```

### Front-end Setup

1. Navigate to the front folder:

cd front

2. Install dependencies:

npm install

3. Start the development server:

ng serve (or 'npm start' if don't have Angular CLI)

### Testing

Back-end Testing
1. Navigate to MovieApi.Tests :
cd MovieApi.Tests

1. Run back-end tests:

dotnet tests

Front-end Testing
Run front-end tests:

ng test (or 'npm test' if don't have Angular CLI)

---

## Structure

### Back-end

The back-end is a MVC application with the following structure:

back/ 
├── MovieApi/ 
│ ├── Controllers/ # Controllers
│ ├── Data/
│ ├── Migrations/
│ ├── Models/ # Business logic
│ ├── Properties/ # Configuration files
│ ├── Program.cs # Configuration & startup file
│ └── test/ 


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
   - Use an in-memory database (e.g., EF) for quick development.
   - Implement CRUD endpoints for managing movies.
   - Add error handling, optimize the code, and ensure the application is secure.

2. **Run and Test the Application**:
   - Build the back-end project using MVC:
   - Start the application:
   - Ensure all tests in `back/test` pass:
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

## Extra challenge

1. **Advancing Application Testing**:
   - Implement comprehensive unit tests for all service and controller layers.
   - Ensure integration tests cover all critical paths and edge cases.
   - Leverage GitHub Actions for continuous integration to automatically run tests on each pull request.

2. **Create a Dockerfile**:
   - Package the back-end and front-end applications into Docker containers.
   - Example for .NET:
        ```Dockerfile
        FROM mcr.microsoft.com/dotnet/aspnet:8.0
        COPY bin/Release/net8.0/publish/ App/
        WORKDIR /App
        ENTRYPOINT ["dotnet", "MovieApi.dll"]
        EXPOSE 80
        ```

3. **Set Up CI/CD**:
   - Create a GitLab CI/CD pipeline for automating builds, tests, and deployments.
   - Example `.gitlab-ci.yml`:
        ```yaml
        stages:
        - build
        - test
        - deploy

        build:
        script:
            - dotnet build

        test:
        script:
            - dotnet test

        deploy:
        script:
            - docker run -d -p 80:80 movie-api
        ```

4. **Generate Visual Documentation**:
   - Use Mermaid diagrams to represent workflows or architecture:
        ```mermaid
        graph TD
        A[User] -->|Interacts| B[Front-end]
        B -->|Requests| C[Back-end API]
        C -->|Stores| D[In-memory DB]
        ```

5. **Automation**:
   - Create a PowerShell script for setting up and running the project end-to-end.

---

# Conclusion
By completing these tasks using GitHub Copilot, you will ensure that both the back-end and front-end parts of the project are functional, secure, and optimized. Use the Resolved folder as a reference to guide your progress.

Good luck! 🚀