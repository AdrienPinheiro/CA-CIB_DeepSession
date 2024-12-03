# Task 4: Centralized Error Management

### **Objective**
Learn how to implement centralized error handling in FastAPI to manage and standardize error responses across the application. Use **GitHub Copilot's chat window and context selection** to help you generate, refine, and improve exception-handling methods.

---

### **Task Description**

1. **Add Exception Handling**:
   - Use FastAPI's built-in features to handle exceptions gracefully.
   - Implement specific handlers for common exceptions, such as `ValueError` for invalid date formats and `HTTPException` for other API errors.
   - Refactor code to improve user feedback for invalid inputs.

2. **Explore Copilot’s Features**:
   - Use GitHub Copilot’s **context selection** feature in its chat window to refine exception-handling logic, ensuring consistency across all endpoints.
   - Experiment with Copilot to generate and refine exception-handling code.

3. **Test Error Scenarios**:
   - Validate your implementation by testing various error scenarios, such as invalid date formats, missing parameters, or general errors.

4. **Swagger Documentation (Optional)**:
   - Utilize FastAPI’s built-in Swagger UI to view how your exceptions are documented automatically.

---

### **File Structure**
```plaintext
/exercices/tasks/task4_error_handling/
    ├── main.py         # Starting file
    ├── solution.py     # Completed solution with global error handling
    ├── readme.md       # This README file
    ├── requirements.txt # Dependencies
```

---

### **Step-by-Step Instructions**

#### **Part 1: Implement Exception Handling**

1. Open the `main.py` file.
2. Add exception handling logic:
   - Implement a handler for `ValueError` to return a clear error message for invalid date formats.
   - Enhance error handling for other cases, such as invalid logic or input errors.
3. Use GitHub Copilot:
   - Open Copilot’s chat window and ask it for suggestions to handle specific exceptions.
   - Refine your code based on its feedback and context suggestions.

#### **Part 2: Test the Application**

1. Run the application using `uvicorn`:
   ```bash
   uvicorn main:app --reload
   ```
2. Use a REST client like **Postman** or the FastAPI Swagger UI at `http://127.0.0.1:8000/docs` to test the following scenarios:
   - **Valid request**: Provide valid dates and verify the correct response.
   - **Invalid date format**: Test with incorrect formats (e.g., `01-01-2023`) to trigger the `ValueError`.
   - **start_date after end_date**: Test with a `start_date` later than the `end_date`.
   - **Other errors**: Simulate unexpected issues to test generic exception handling.

---

### **What You’ll Learn**
1. How to handle exceptions in FastAPI using custom handlers.
2. How to provide meaningful and user-friendly error messages.
3. How to use GitHub Copilot to streamline development and generate robust code.

---

### **Additional Exercises**
1. Add additional exception handlers for errors such as `KeyError` or `AttributeError`.
2. Experiment with how Swagger documents your exception responses automatically.
3. Discuss and implement techniques to secure your API by limiting exposed error details.

---

### **Example Usage**

#### Valid Request:
```bash
GET /api/task4/days-between?start_date=2023-01-01&end_date=2023-01-10
Response: {"days_between": 9}
```

#### Invalid Date Format:
```bash
GET /api/task4/days-between?start_date=01-01-2023&end_date=10-01-2023
Response: {"detail": "Invalid date format. Use YYYY-MM-DD."}
```

#### start_date After end_date:
```bash
GET /api/task4/days-between?start_date=2023-01-10&end_date=2023-01-01
Response: {"detail": "start_date cannot be after end_date"}
```

#### Generic Error (Simulated):
```bash
GET /api/task4/days-between?start_date=null&end_date=2023-01-10
Response: {"detail": "An unexpected error occurred"}
```
