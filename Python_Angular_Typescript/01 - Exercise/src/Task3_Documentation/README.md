# Task 3: Documentation and Automatic API Generation

### Objective
Learn how to document REST API endpoints using docstrings and generate interactive API documentation using **Swagger** with **FastAPI**.

---

### Task Description
1. **Add Docstrings to your REST endpoints**:
   - Use **GitHub Copilot** to automatically generate docstrings for the endpoints.
   - Docstrings should describe the method's functionality, parameters, and return values.

2. **Set Up Swagger**:
   - FastAPI automatically generates Swagger documentation for the API.
   - Test your documentation using the Swagger UI.

---

### Endpoint Details:
- **Path**: `/docs`
- **HTTP Method**: `GET`
- **Query Parameters**:
  - None
- **Responses**:
  - Interactive Swagger UI that documents all the available endpoints in your FastAPI application.

---

### File Structure
```plaintext
Task3_Documentation/
├── main.py                # Starter file with documentation
├── solution.py            # Fully implemented solution
├── requirements.txt       # Dependencies
└── README.md              # Task instructions
```

---

### Step-by-Step Instructions

#### **Part 1: Add Docstrings**

1. **Use GitHub Copilot to Add Docstrings**:
   - Open `main.py` in your editor.
   - For each function, place your cursor above the function definition.
   - Use **GitHub Copilot** to generate docstrings by typing:
     ```
     """Generate docstring for the function."""
     ```
   - Accept Copilot’s suggestions to automatically add docstrings.

#### **Part 2: Swagger Setup**

1. **Swagger Documentation in FastAPI**:
   - FastAPI automatically generates Swagger UI by default, and no additional configuration is required to enable it.
   - Simply run the FastAPI server:
     ```bash
     uvicorn main:app --reload
     ```

2. **Access Swagger UI**:
   - Open a browser and go to:  
     ```bash
     http://127.0.0.1:8000/docs
     ```

   - This will show the interactive Swagger UI with all the API documentation.

---

### What You’ll Learn
- How to document your API endpoints using docstrings.
- How to leverage FastAPI's built-in Swagger integration for automatic API documentation.
- The importance of documenting APIs to make your application easier to integrate with and maintain.

---

### Additional Challenges
1. Add custom error messages to the Swagger documentation for validation errors.
2. Explore how to secure the Swagger UI using FastAPI's dependency injection system.
3. Experiment with generating API client code using the OpenAPI specification.

---

### Troubleshooting
- **Error**: `No response from Swagger UI`:
  - Ensure the FastAPI server is running and visit the correct URL (`http://127.0.0.1:8000/docs`).

- **Swagger UI is not interactive**:
  - Make sure you are accessing the `/docs` endpoint and that you are using a compatible browser.

---

### Next Steps
Once you’ve completed this task, move on to **Task 4** where you will learn more about securing APIs and adding authentication.