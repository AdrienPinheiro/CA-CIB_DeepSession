# Task 1: Hello Copilot

### Objective
This task introduces you to creating a simple REST endpoint using **Spring Boot**. The goal is to familiarize yourself with the basics of **GitHub Copilot** and how it can assist in writing boilerplate code for Java applications.

---

### Task Description
You need to create a REST controller in Spring Boot that responds to HTTP `GET` requests with a simple message: `"Hello, Copilot!"`.

#### Endpoint Details:
- **Path**: `/api/task1/hello`
- **HTTP Method**: `GET`
- **Response**: `"Hello, Copilot!"`

---

### File Structure
```plaintext
src/main/java/com/deep_session/exercices/tasks/
    └── Task1_Hello/
          └── Task1HelloController.java
```

---

### Step-by-Step Instructions

1. **Use GitHub Copilot to Generate Code**:
   - Open `Task1HelloController.java` in your editor (e.g., Visual Studio Code, IntelliJ IDEA).
   - Start by typing the following at the top of the file to define the package and import statements:
     ```java
     package com.deep_session.exercices.Task1_Hello;

     import org.springframework.web.bind.annotation.*;
     ```
   - Now, place your cursor below these lines and **ask GitHub Copilot** to generate the controller class:
     - Use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to open the input field for Copilot.
     - Type the following prompt:
       ```
       Create a REST controller in Spring Boot with a GET endpoint /hello that returns "Hello, Copilot!"
       ```
   - Accept Copilot’s suggestions to generate the necessary code. 

2. **Test the Generated Code**:
   - Run the `DeepSessionExercicesApplication` class to start your Spring Boot application.
   - Use a browser or tool like Postman to access the endpoint:
     ```
     http://localhost:8080/api/task1/hello
     ```
   - You should see the response:  
     ```
     Hello, Copilot!
     ```

---

### What You’ll Learn
- How to use **GitHub Copilot** to quickly scaffold boilerplate code.
- How to create a REST API endpoint using Spring Boot.
- Basics of Java package organization and naming conventions.

---

### Additional Challenges
1. Modify the `/hello` endpoint to include your name, e.g., `"Hello, [Your Name]! Copilot loves your work!"`.
2. Add a new endpoint `/goodbye` that returns `"Goodbye, Copilot!"`.
3. Experiment with prompting Copilot to add comments to explain the generated code.

---

### Troubleshooting
- **Error**: `The declared package does not match the expected package`:  
  Ensure the `Task1HelloController.java` file is placed in the folder:  
  `src/main/java/com/deep_session/exercices/tasks/Task1_Hello/`.

- **Port Already in Use**:  
  If the application fails to start, check if another application is using port `8080` or modify the port in `application.properties`.

---

### Using GitHub Copilot Efficiently
- **Prompt Suggestions**: Write clear, concise prompts to get the best results from Copilot. For example:
  - `"Create a REST API endpoint in Spring Boot that responds to GET /hello with a message 'Hello, Copilot!'."`
  - `"Add a class-level request mapping for /api/task1 in a Spring Boot REST controller."`
- **Experiment**: Try different prompts and observe how Copilot adapts its suggestions.

---

### Next Steps
After completing this task, proceed to **Task 2**, where you will learn how to handle request parameters to make your endpoints more dynamic.