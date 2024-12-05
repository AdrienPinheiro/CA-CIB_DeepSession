# Task 4: Centralized Error Management

### **Objective**
Learn how to set up a **global error handling mechanism** in ASP.NET Core using `ExceptionFilterAttribute`, while leveraging **GitHub Copilot's chat window and context selection** to generate and refine exception-handling methods. This approach ensures students explore Copilot's advanced features and understand centralized error handling in ASP.NET Core.

---

### **Task Description**
1. **Create a Global Exception Handler**:
   - Use `ExceptionFilterAttribute` to define a centralized class for handling exceptions across the application.
   - Implement exception-specific handling using `OnException` method.

2. **Explore Copilot’s Context Selection**:
   - Use the **context selection feature** in Copilot’s chat window to refine exception handling logic by reviewing multiple controller classes in your project.

3. **Handle Specific Exceptions**:
   - Add handlers for `FormatException` and `ArgumentException` to return user-friendly error messages.
   - Handle `NullReferenceException` and general exceptions for robust fallback behavior.

4. **Enhance Swagger Documentation** (Optional):
   - Demonstrate how the exception responses integrate with Swagger, if available.

---

### **File Structure**
```plaintext
01-Exercise/Exercise
    └── Task4_ErrorHandling/
          └── Task4ErrorHandling.cs
```

---

### **Step-by-Step Instructions**

#### **Define the Exception Handler Class**

1. Open the `GlobalExceptionHandler.cs` file.
2. Use **GitHub Copilot's context selection feature**:
   - Open Copilot's chat window and load related controller classes in your project.
   - Use context selection to let Copilot understand the broader codebase for better suggestions.
3. Generate exception-handling methods using Copilot:
   - Inside the class, use a prompt inspired by the following ones in the chat window:
     ```c#
     Write an exception handler for DateTimeParseException with a custom error message.
     ```
     ```c#
     Add a handler for NullPointerException to return a generic error response.
     ```
---

#### **Implement Handlers for Common Exceptions**

Use Copilot's suggestions to implement methods like:

```c#
private ObjectResult HandleFormatException(string message)
{
   return new BadRequestObjectResult("Message : " + message);
}

private ObjectResult HandleNullReferenceException(string message)
{
   return new ObjectResult("A null value was encountered: " + message) { StatusCode = 500 };
}

private ObjectResult HandleArgumentException(string message)
{
   return new BadRequestObjectResult("Invalid argument: " + message);
}

private ObjectResult HandleDateTimeParseException(string message)
{
   return new BadRequestObjectResult("DateTime parsing error: " + message);
}

private ObjectResult HandleGenericException(string message)
{
   return new ObjectResult("An error occurred: " + message) { StatusCode = 500 };
}
```

---

#### **Test Exception Handling**

1. Implement the new error handler inside the class `Task4DaysBetweenController.cs`
2. Run the application and use a REST client (e.g., Postman) to test various endpoints:
   - Test invalid date formats to trigger `FormatException`.
   - Add scenarios in your code to provoke `NullPointerException` and `IllegalArgumentException`.
   - Verify generic exception handling by introducing an unexpected error.

3. Use Copilot to refine and test changes:
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