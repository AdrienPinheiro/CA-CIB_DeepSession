# Task 3: Documentation and Automatic API Generation

### Objective
Learn how to document REST API endpoints using JavaDocs and generate interactive API documentation using **Swagger**.

---

### Task Description
1. **Add JavaDocs to your REST endpoints**:
   - Use **GitHub Copilot** to automatically generate JavaDocs for the endpoints.
   - JavaDocs should describe the method's functionality, parameters, and return values.

2. **Set Up Swagger**:
   - Configure your project to use **Swagger** for automatic API documentation.
   - Test your documentation using the Swagger UI.

---

### File Structure
```plaintext
src/main/java/com/deep_session/exercices/tasks
    └── Task3_Documentation/
          └── Task3DocumentationController.java
```

---

### Step-by-Step Instructions

#### **Part 1: Add JavaDocs**

1. **Use GitHub Copilot to Add JavaDocs**:
   - Open `Task3DocumentationController.java`.
   - For each method, place your cursor above the method declaration.
   - Use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to open the Copilot prompt. Use the command `/doc` to generate JavaDocs.
   - Accept the suggested JavaDocs.

#### **Part 2: Configure Swagger**

1. **Add Swagger Dependency**:
   - Open your `pom.xml` file and add the following dependency:
     ```xml
     <dependency>
         <groupId>org.springdoc</groupId>
         <artifactId>springdoc-openapi-ui</artifactId>
         <version>1.6.15</version>
     </dependency>
     ```

2. **Access Swagger UI**:
   - Run your Spring Boot application.
   - Open your browser and go to:  
     ```
     http://localhost:8080/swagger-ui.html
     ```

---

### **What You’ll Learn**
- How to use **GitHub Copilot** to document code automatically.
- The importance of documenting API endpoints to facilitate collaboration and integration.
- How to generate and test interactive API documentation using Swagger.

---

### **Discussion Points**

1. **Why Document APIs?**
   - Ensures clarity for future developers.
   - Simplifies integration for external teams.
   - Acts as a contract between API developers and consumers.

2. **Swagger and Team Collaboration**:
   - Swagger UI provides an interactive interface for testing APIs.
   - Helps non-developers (e.g., QA teams, product managers) understand API capabilities.

---

### Additional Challenges
1. Add custom error messages to the Swagger documentation for validation errors.
2. Explore how to secure the Swagger UI using Spring Security.
3. Experiment with generating API client code using the OpenAPI specification.