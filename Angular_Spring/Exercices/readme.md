# **Deep Session Exercises - Java Spring**

This repository contains a series of tasks designed to help developers practice and enhance their skills using GitHub Copilot, Spring Boot, and Java. Each task is organized with **instructions** and **solutions** in separate directories for clarity and ease of use.

---

## **Project Structure**

The repository is structured as follows:

```
src/
├── main/
│   └── java/
│       └── com/
│           └── deep_session/
│               ├── exercices/
│               │   ├── solutions/        # Contains solution files for each task
│               │   │   └── TaskX_Name/
│               │   │       └── <SolutionFiles>.java
│               │   ├── tasks/            # Contains task instructions and exercise starter files
│               │   │   └── TaskX_Name/
│               │   │       ├── <ExerciseFiles>.java
│               │   │       └── README.md
│               └── DeepSessionExercicesApplication.java
└── pom.xml
```

### **Directory Details**

- **`tasks/`**: 
  - Contains the exercise starter files and their corresponding `README.md` for guidance.
  - Each task is placed under `src/main/java/com/deep_session/exercices/tasks/TaskX_Name/`.

- **`solutions/`**:
  - Contains the fully implemented solutions for each task.
  - Each solution is placed under `src/main/java/com/deep_session/exercices/solutions/TaskX_Name/`.

---

## **How to Run the Application**

Follow these steps to set up and run the application:

### **1. Prerequisites**
- Ensure you have **Java JDK 17 or higher** installed:
  ```bash
  java -version
  ```
- Install **Maven** for dependency management:
  ```bash
  mvn -version
  ```
- (Optional) Use an IDE such as IntelliJ IDEA or Eclipse for code navigation and editing.

---

### **2. Build the Project**
Navigate to the project root (where the `pom.xml` file is located) and run:
```bash
mvn clean install
```

---

### **3. Run the Application**
Start the application using:
```bash
mvn spring-boot:run
```

Alternatively, you can run the JAR file:
```bash
java -jar target/deep_session_exercices-0.0.1-SNAPSHOT.jar
```

---

### **4. Access the Endpoints**
Each task's functionality is exposed as a REST API endpoint.

#### Example:
- For **Task 1** (`Hello, Copilot!`):
  - URL: [http://localhost:8080/api/hello](http://localhost:8080/api/hello)
  - Expected Output: `"Hello, Copilot!"`

- For **Task 2** (`Days Between Two Dates`):
  - URL: [http://localhost:8080/api/days-between](http://localhost:8080/api/days-between)
  - Query Parameters: 
    ```
    startDate=2024-11-01&endDate=2024-11-10
    ```
  - Expected Output: `9`

Refer to the **`tasks/`** directory for specific instructions and endpoints for each task.

---

## **How to Use This Repository**

1. **Start with the Exercises:**
   - Navigate to `src/main/java/com/deep_session/exercices/tasks/TaskX_Name/`.
   - Read the `README.md` file for instructions.
   - Use the starter file in the same directory to begin coding.

2. **Use GitHub Copilot:**
   - Leverage Copilot for code suggestions by typing within the starter files.
   - Use commands like `Ctrl + I` to open input fields for Copilot prompts.

3. **Check Solutions:**
   - Once you've attempted the exercise, compare your work with the solution in `src/main/java/com/deep_session/exercices/solutions/TaskX_Name/`.

---

## **Additional Notes**

- **Documentation**: 
  - Some tasks include Swagger configuration for interactive API documentation. Access Swagger UI at:
    ```
    http://localhost:8080/swagger-ui.html
    ```

- **Error Handling**:
  - Task 4 introduces centralized error management to enhance API robustness. Familiarize yourself with `@ControllerAdvice` for a global exception-handling mechanism.

- **Code Refactoring**:
  - Task 5 focuses on optimizing repetitive code. Use GitHub Copilot to identify patterns and refactor effectively.

---

## **Contributing**
Contributions are welcome! If you have suggestions for new exercises or improvements, feel free to submit a pull request.

---

Happy coding! 🚀

---