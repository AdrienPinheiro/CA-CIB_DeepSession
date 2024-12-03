# Task 1: Hello Copilot

### Objective
This task introduces you to creating a simple REST endpoint using **FastAPI**. The goal is to familiarize yourself with the basics of **GitHub Copilot** and how it can assist in writing boilerplate code for Python applications.

---

### Task Description
You need to create a FastAPI application that responds to HTTP `GET` requests with a simple message: `"Hello, Copilot!"`.

#### Endpoint Details:
- **Path**: `/hello`
- **HTTP Method**: `GET`
- **Response**: `"Hello, Copilot!"`

---

### File Structure
```plaintext
Task1_Hello/
├── main.py                 # Starter file
├── solution.py             # Fully implemented solution
├── requirements.txt        # Dependencies
└── README.md               # Task instructions
```

---

### Step-by-Step Instructions

1. **Use GitHub Copilot to Generate Code**:
   - Open `main.py` in your editor (e.g., Visual Studio Code or PyCharm).
   - Start by typing the following:
     ```python
     from fastapi import FastAPI
     app = FastAPI()
     ```
   - Now, use **GitHub Copilot** to complete the function:
     - Write a prompt such as:
       ```
       Create a GET endpoint /hello that returns "Hello, Copilot!".
       ```
   - Accept Copilot’s suggestions to generate the necessary code.

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
   - Open a browser or use Postman to access:
     ```
     http://127.0.0.1:8000/hello
     ```
   - The response should be:
     ```json
     "Hello, Copilot!"
     ```

---

### What You’ll Learn
- How to use **GitHub Copilot** for scaffolding code.
- Basics of creating REST endpoints in FastAPI.
- How to run and test a FastAPI application.

---

### Additional Challenges
1. Modify the `/hello` endpoint to include your name, e.g., `"Hello, [Your Name]! Copilot thinks you're awesome!"`.
2. Add a new endpoint `/goodbye` that returns `"Goodbye, Copilot!"`.
3. Use Copilot to generate automated comments for your code.

---

### Troubleshooting
- **Dependency Issues**:
  - Ensure FastAPI and Uvicorn are installed by running:
    ```bash
    pip install fastapi uvicorn
    ```

- **Port Already in Use**:
  - Run the server on a different port using:
    ```bash
    uvicorn main:app --reload --port 8001
    ```

---

### Next Steps
Once you’ve completed this task, move on to **Task 2** where you’ll learn to handle query parameters for more dynamic endpoints.