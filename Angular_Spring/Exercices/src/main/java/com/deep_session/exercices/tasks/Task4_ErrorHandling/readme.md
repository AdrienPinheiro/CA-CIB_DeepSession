# Task 4: Centralized Error Management

### **Objective**
Learn how to set up a **global error handling mechanism** in Spring Boot using `@ControllerAdvice`, while leveraging **GitHub Copilot's chat window and context selection** to generate and refine exception-handling methods. This approach ensures students explore Copilot's advanced features and understand centralized error handling in Spring Boot.

---

### **Task Description**
1. **Create a Global Exception Handler**:
   - Use `@ControllerAdvice` to define a centralized class for handling exceptions across the application.
   - Implement exception-specific handling using `@ExceptionHandler`.

2. **Explore Copilot’s Context Selection**:
   - Use the **context selection feature** in Copilot’s chat window to refine exception handling logic by reviewing multiple controller classes in your project.

3. **Handle Specific Exceptions**:
   - Add handlers for `DateTimeParseException` and `IllegalArgumentException` to return user-friendly error messages.
   - Handle `NullPointerException` and general exceptions for robust fallback behavior.

4. **Enhance Swagger Documentation** (Optional):
   - Demonstrate how the exception responses integrate with Swagger, if available.

---

### **File Structure**
```plaintext
src/main/java/com/deep_session/exercices/tasks
    └── Task4_ErrorHandling/
          └── GlobalExceptionHandler.java
```

---

### **Step-by-Step Instructions**

#### **Define the Exception Handler Class**

1. Open the `GlobalExceptionHandler.java` file.
2. Start by defining a basic structure:
   ```java
   @ControllerAdvice
   public class GlobalExceptionHandler {
   }
   ```
3. Use **GitHub Copilot's context selection feature**:
   - Open Copilot's chat window and load related controller classes in your project.
   - Use context selection to let Copilot understand the broader codebase for better suggestions.

4. Generate exception-handling methods using Copilot:
   - Inside the class, use a prompt inspired by the following ones in the chat window:
     ```java
     Write an exception handler for DateTimeParseException with a custom error message.
     ```
     ```java
     Add a handler for NullPointerException to return a generic error response.
     ```

---

#### **Implement Handlers for Common Exceptions**

Use Copilot's suggestions to implement methods like:

```java
@ExceptionHandler(DateTimeParseException.class)
public ResponseEntity<String> handleDateTimeParseException(DateTimeParseException e) {
    return ResponseEntity.badRequest().body("Invalid date format: " + e.getParsedString());
}

@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body("Illegal argument: " + e.getMessage());
}

@ExceptionHandler(NullPointerException.class)
public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
    return ResponseEntity.internalServerError().body("A required value was null. Please check your request.");
}

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleGeneralException(Exception e) {
    return ResponseEntity.internalServerError().body("An unexpected error occurred: " + e.getMessage());
}
```

---

#### **Test Exception Handling**

1. Run the application and use a REST client (e.g., Postman) to test various endpoints:
   - Test invalid date formats to trigger `DateTimeParseException`.
   - Add scenarios in your code to provoke `NullPointerException` and `IllegalArgumentException`.
   - Verify generic exception handling by introducing an unexpected error.

2. Use Copilot to refine and test changes:
   - Ask Copilot's chat window for ways to test the error-handling methods.
   - Refine responses with more detailed error messages or logging, guided by Copilot's suggestions.

---

### **What You’ll Learn**
1. **Centralized Error Management**:
   - Maintain consistent error responses across controllers.
   - Simplify debugging and maintenance by consolidating exception logic.

2. **Copilot’s Context Selection**:
   - Learn to leverage context selection to improve Copilot’s code generation capabilities.
   - Explore how Copilot adapts to larger codebases for accurate suggestions.

3. **Swagger Integration (Optional)**:
   - View the exception-handling responses in Swagger’s documentation if enabled.

---

### **Additional Exercises**

1. Extend the `GlobalExceptionHandler`:
   - Add handling for other exceptions, such as `ConstraintViolationException`.
   - Discuss the security implications of returning detailed error messages.

2. Explore how context selection helps:
   - Test how different selections (e.g., specific controller files vs. the whole project) influence Copilot’s suggestions.

3. Discuss with your team:
   - The pros and cons of centralized vs. distributed error handling.
   - Best practices for balancing user-friendly error messages with application security.