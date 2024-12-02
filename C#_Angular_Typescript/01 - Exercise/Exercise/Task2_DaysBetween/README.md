# Task 2: Calculating Days Between Two Dates

### Objective
This task introduces you to creating a REST endpoint with parameters and implementing basic business logic by using **GitHub Copilot Chat**. You’ll also learn how to validate user input using **.NET 8** and handle exceptions gracefully.

---

### Task Description
Create a REST endpoint that calculates the number of days between two given dates. The endpoint should:
- Accept two query parameters: `startDate` and `endDate`.
- Validate that the date inputs are in the correct format (`YYYY-MM-DD`).
- Return the difference in days between the two dates.
- Return an error if:
  - The `startDate` is after the `endDate`.
  - The dates are not in the correct format.

---

### Endpoint Details:
- **Path**: `/api/task2/days-between`
- **HTTP Method**: `GET`
- **Query Parameters**:
  - `startDate`: The starting date in `YYYY-MM-DD` format.
  - `endDate`: The ending date in `YYYY-MM-DD` format.
- **Responses**:
  - The difference in days as an integer (if valid inputs are provided).
  - Error messages if inputs are invalid.

---

### File Structure
```plaintext
Exercise/Task2/
    └── Task2_DaysBetween/
          └── Task2DaysBetweenController.java
```

---

### Step-by-Step Instructions

1. **Use GitHub Copilot to Generate Code**:
   - Open `Task2DaysBetweenController.cs` in your editor.
   - Place your cursor inside the class and **ask GitHub Copilot** to generate the various methods :
     - Use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to open the input field for Copilot.
     - Type the following prompt:
       ```
       Create a REST API in .NET 8 with a GET endpoint /days-between. It accepts two query parameters, startDate and endDate, validates them, and returns the number of days between the dates.
       ```
   - Accept Copilot’s suggestions to generate the necessary code.

2. **Test the Generated Code**:
   - Run the `Task2DaysBetweenController` class to start your Spring Boot application.
   - Use a browser or tool like Postman to test the endpoint:  
     ```
     http://localhost:8080/api/task2/days-between?startDate=2023-01-01&endDate=2023-01-10
     ```
   - Expected Response:  
     ```
     9
     ```
  
3. **Generate the unit tests**:
   - Open the chat window and use the `/test` command to generate unit tests for the endpoint. You will need to tag `@workspace` to give your assistant access to the project files.
   - Review the generated tests and run them to validate the endpoint's functionality.

---

### What You’ll Learn
- How to create a REST API endpoint that accepts and validates query parameters.
- How to perform business logic using Java’s `LocalDate` and `ChronoUnit` classes.
- How to handle invalid input gracefully using exception handling in **Spring Boot**.

---

### Additional Challenges
1. Modify the endpoint to also return the number of weekdays between the two dates.
2. Add unit tests for the endpoint to validate its functionality and error handling.
3. Experiment with GitHub Copilot by prompting it to generate additional validation logic (e.g., checking if a date is in the future, different format (ex: Japanese format)).

---

### Troubleshooting
- **Error**: `The declared package does not match the expected package`:  
  Ensure the `Task2DaysBetweenController.java` file is placed in the folder:  
  `src/main/java/com/deep_session/exercices/tasksTask2_DaysBetween/`.

- **Date Parsing Errors**:  
  If you receive an error message about invalid date formats, ensure the query parameters are in `YYYY-MM-DD` format.

- **Port Already in Use**:  
  If the application fails to start, check if another application is using port `8080` or modify the port in `application.properties`.

---

### Using GitHub Copilot Efficiently
- **Prompt Suggestions**: Write clear, concise prompts to get accurate suggestions. For example:
  - `"Create a GET endpoint in .NET 8 to calculate days between two dates with validation."`
  - `"Add error handling for invalid date formats in a .NET 8 REST API."`
- **Experiment**: Try different prompts and see how Copilot adapts its suggestions.

---

### Next Steps
After completing this task, proceed to **Task 3**, where you’ll explore building more complex logic using multiple parameters and external APIs.
