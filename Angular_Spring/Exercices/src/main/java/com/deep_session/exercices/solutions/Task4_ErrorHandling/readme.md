# Task 4: Centralized Error Management

### Objective
Learn how to set up a **global error handling mechanism** in Spring Boot using `@ControllerAdvice`. This approach allows you to manage exceptions across all controllers in your application in a centralized and consistent way.

---

### Task Description
1. **Create a Global Exception Handler**:
   - Use `@ControllerAdvice` to define a class for handling exceptions globally.
   - Use `@ExceptionHandler` to specify methods for different exception types.

2. **Handle Specific Exceptions**:
   - Add logic to handle `DateTimeParseException` and provide a user-friendly error message.
   - Add handling for `NullPointerException` and general exceptions.

3. **Complementary Discussion**:
   - Understand the benefits of centralized error handling.
   - Learn the difference between `Exception` and `RuntimeException`.

4. **Additional Exercise**:
   - Add logic to capture and handle `NullPointerException`.

---

### File Structure
```plaintext
src/main/java/com/deep_session/exercices/
    └── Task4_ErrorHandling/
          └── GlobalExceptionHandler.java
```

---

### Step-by-Step Instructions

#### **Part 1: Set Up the Directory**

1. Navigate to `src/main/java/com/deep_session/exercices/`.
2. Create a new folder named `Task4_ErrorHandling`.

#### **Part 2: Create the Exception Handler**

1. Inside the `Task4_ErrorHandling` directory, create a new file `GlobalExceptionHandler.java`.
2. Use **GitHub Copilot** to help generate exception handling methods:
   - Open the file and start by defining the class:
     ```java
     @ControllerAdvice
     public class GlobalExceptionHandler {
     }
     ```
   - Place your cursor inside the class and use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to prompt Copilot. Example prompts:
     ```
     Write an exception handler for DateTimeParseException in Spring Boot.
     Write a global handler for NullPointerException.
     ```
   - Accept Copilot's suggestions to generate the methods.

#### **Part 3: Test the Global Exception Handling**

1. Run your Spring Boot application.
2. Use a REST client (e.g., Postman) to test various endpoints and provoke errors:
   - Provide invalid date formats to test `DateTimeParseException`.
   - Trigger a `NullPointerException` in your application to verify handling.

---

### **What You’ll Learn**
- The benefits of centralizing error handling:
  - Consistent error messages across endpoints.
  - Simplified maintenance of error-handling logic.
- The difference between `Exception` and `RuntimeException`:
  - **Exception**: Checked exceptions, which must be explicitly handled in your code.
  - **RuntimeException**: Unchecked exceptions, which occur during runtime and may not require explicit handling.

---

### **Additional Exercise**
1. Extend the `GlobalExceptionHandler` to handle additional exceptions commonly encountered in your application.
2. Discuss with your team:
   - How centralized error handling improves code quality and simplifies debugging.
   - Best practices for returning descriptive yet secure error messages to clients.

---

### Example Swagger Documentation Integration
If you've configured Swagger (from Task 3), the error-handling methods will automatically appear in the API documentation, showing potential response types for exceptions.