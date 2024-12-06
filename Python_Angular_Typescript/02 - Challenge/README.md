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
   - [Proxy Setup](#proxy-setup)
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

- **Back-end**: A FastAPI application for managing movies via a REST API.
- **Front-end**: An Angular application providing a user-friendly interface for interacting with the API.

---

## Setup Instructions

### Configure CA-CIB proxy:

  In VsCode :

  Configure the proxy settings in your settings.json file, you can add the http.proxy and http.proxyAuthorization settings. 

  Replace http.proxyAuthorization: null with your actual proxy authorization details.
  Add the http.proxy setting with your proxy server details.
  Here is the updated settings.json:

  {
      "workbench.colorTheme": "One Dark Pro Darker",
      "liveServer.settings.donotShowInfoMsg": true,
      "http.proxy": "http://username:password@proxyserver:port",
      "http.proxyAuthorization": "Basic base64encodedusername:password"
  }

  In IntelliJ IDEA :

  To configure proxy settings in IntelliJ IDEA, you can follow these steps to set up the proxy in the idea.properties file, which is the configuration file that IntelliJ IDEA uses for its network settings:

  Here is the short version of how to set up the proxy:

  Locate the idea.properties file:

  On Windows: C:\Users\<YourUsername>\AppData\Roaming\JetBrains\IntelliJIdea<version>\idea.properties
  On macOS/Linux: ~/.IntelliJIdea<version>/config/idea.properties
  Edit idea.properties: Open the file and add the following proxy settings.

  # Proxy settings
  idea.proxy.host=proxyserver
  idea.proxy.port=port
  idea.proxy.user=username
  idea.proxy.password=password
  idea.proxy.type=HTTP   # or SOCKS5 if you're using SOCKS proxy
  idea.proxy.authentication=basic
  Replace the placeholders:

  proxyserver with your proxy server URL (e.g., proxy.par.emea.cib).
  port with your proxy server port number (e.g., 8080).
  username and password with your proxy credentials.
  Base64 Encoding for Proxy Password (Optional): IntelliJ IDEA does not require base64 encoding for the proxy password in idea.properties. However, if needed, IntelliJ IDEA supports basic authentication where you simply enter the plain username and password.

  Restart IntelliJ IDEA: After saving the changes, restart IntelliJ IDEA to apply the new proxy settings.

### Back-end Setup

1. Ensure **Python 3.10 or higher** is installed on your system:
  ```bash
  python --version
  ```
  If not installed, download it from the [official Python website](https://www.python.org/downloads/).

- Install **pip**, Python's package manager (usually included with Python).

2. Use a Virtual Environment:
  It’s highly recommended to create a virtual environment for each task to avoid dependency conflicts.

  In VsCode : 

  Press Ctrl + Shift + P to open the Command Palette.
  Type Python: Select Interpreter and select the correct Python interpreter from the list.

  Open Command Palette:
  Use the Python: Create Environment command to create a virtual environment.
  Show in Command Palette
  Select Environment Type:

  Choose the environment type venv from the list presented.
  Select the Python interpreter you want to use as the base for the new virtual environment.

  In InteeliJ IDEA :

  Install the Python plugin (if not already installed) via File → Settings → Plugins.
  Go to File → Settings → Project: [Your Project] → Python Interpreter.
  Select your Python interpreter (System or Virtual Environment).

  Go to Settings → Python Interpreter → Add Interpreter → Virtual Environment.
  Choose the location for the new environment and select the Python version.

  Activate the Environment :
  ```bash
  python -m venv venv
  source venv/bin/activate    # On Linux/Mac
  venv\Scripts\activate       # On Windows
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
1. Run back-end tests:

./mvnw test

Front-end Testing
Run front-end tests:

ng test (or 'npm test' if don't have Angular CLI)

---

## Structure

### Back-end

The back-end is a FastAPI application with the following structure:

back/
├── app/
│   ├── __init__.py
│   ├── main.py # Entry point for the application
│   ├── models.py # Database models
│   ├── schemas.py # Pydantic models (schemas)
│   ├── crud.py # CRUD operations
│   ├── database.py # Database connection and setup
│   └── routers/ # API endpoints
│       ├── __init__.py
│       └── movies.py # Movie-related endpoints
├── tests/
│   ├── __init__.py
│   ├── test_main.py # Tests for main application
│   └── test_movie.py # Tests for movie endpoints
├── venv/ # Virtual environment directory
├── requirements.txt # Python dependencies
└── README.md # Project documentation


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
   - Use an in-memory database (e.g., SQLite) for quick development.
   - Implement CRUD endpoints for managing movies using FastAPI.
   - Add error handling, optimize the code, and ensure the application is secure.

2. **Run and Test the Application**:
   - Launch the FastAPI application to serve the REST API endpoints. 
   This will allow you to interact with the API for creating, reading, updating, and deleting movie records.

3. **Optional Enhancements**:
   - Add additional endpoints (e.g., advanced search, batch updates).
   - Use FastAPI's exception handlers for centralized error handling.
   - Generate API documentation using FastAPI's built-in Swagger UI.

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
   - Example for FastAPI:
         ```Dockerfile
         FROM python:3.10-slim

         # Set the working directory
         WORKDIR /app

         # Copy the requirements file
         COPY requirements.txt .

         # Install dependencies
         RUN pip install --no-cache-dir -r requirements.txt

         # Copy the application code
         COPY . .

         # Expose the port FastAPI will run on
         EXPOSE 8000

         # Command to run the FastAPI application
         CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]
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
            - mvn clean install
            - docker build -t movie-api .

        test:
        script:
            - mvn test

        deploy:
        script:
            - docker run -d -p 8080:8080 movie-api
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