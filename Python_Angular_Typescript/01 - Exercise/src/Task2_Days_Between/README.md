# Task 2: Calculating Days Between Two Dates

### Objective
This task introduces you to creating a REST endpoint with query parameters and implementing basic business logic. You’ll also learn how to validate user input and handle exceptions gracefully using **FastAPI**.

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
- **Path**: `/days-between`
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
Task2_DaysBetween/
├── main.py                # Starter file
├── solution.py            # Fully implemented solution
├── requirements.txt       # Dependencies
└── README.md              # Task instructions
```

---

### Step-by-Step Instructions

1. **Use GitHub Copilot to Generate Code**:
   - Open `main.py` in your editor (e.g., Visual Studio Code or PyCharm).
   - Start by typing the following:
     ```python
     from fastapi import FastAPI, HTTPException
     from datetime import datetime
     app = FastAPI()
     ```
   - Now, use **GitHub Copilot** to complete the function:
     - Write a prompt in the chat window, such as:
       ```
       Create a GET endpoint /days-between. It accepts two query parameters, startDate and endDate, validates them, and returns the number of days between the dates.
       ```
   - Accept Copilot’s suggestions and add them to your file.

2. **Run the Application**:
   - Install the required dependencies:
     ```bash
     pip install -r requirements.txt
     ```
   - Start the FastAPI server:
     ```bash
     uvicorn main:app --reload
     ```

3. **Test the Endpoint**:
   - Open a browser or use Postman to test the endpoint:
     ```bash
     http://127.0.0.1:8000/days-between?startDate=2023-01-01&endDate=2023-01-10
     ```
   - The expected response should be:
     ```json
     9
     ```

---

### What You’ll Learn
- How to create a REST API endpoint that accepts and validates query parameters.
- How to handle business logic using Python's `datetime` module.
- How to handle errors and invalid input using FastAPI.

---

### Additional Challenges
1. Modify the endpoint to also return the number of weekdays between the two dates.
2. Add unit tests for the endpoint to validate its functionality and error handling.
3. Experiment with GitHub Copilot by prompting it to generate additional validation logic (e.g., checking if a date is in the future).

---

### Troubleshooting
- **Error**: `Invalid date format`:
  - Ensure the query parameters are in the `YYYY-MM-DD` format.

- **Port Already in Use**:
  - If the application fails to start, run the server on a different port using:
    ```bash
    uvicorn main:app --reload --port 8001
    ```

---

### Next Steps
Once you’ve completed this task, move on to **Task 3** where you’ll learn how to handle more advanced input validation and responses.