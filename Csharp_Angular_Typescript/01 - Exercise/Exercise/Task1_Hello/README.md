# Task 1: Hello Copilot

### Objective
This task introduces you to creating a simple REST endpoint in **.NET 8**. The goal is to familiarize yourself with the basics of **GitHub Copilot** and how it can assist in writing boilerplate code for .NET applications.

---

### Task Description
You need to create a REST controller in .NET that responds to HTTP `GET` requests with a simple message: `"Hello, Copilot!"`.

#### Endpoint Details:
- **Path**: `/api/task1/hello`
- **HTTP Method**: `GET`
- **Response**: `"Hello, Copilot!"`

---

### File Structure
```plaintext
Exercise
    └── Task1_Hello/
          └── Task1HelloController.cs
```

---

### Step-by-Step Instructions

1. **Use GitHub Copilot to Generate Code**:
   - Open `Task1HelloController.cs` in your editor (e.g., Visual Studio Code, IntelliJ IDEA, Visual Studio).
   - Now, place your cursor inside the class to generate the adaquate method inside the controller class :
     - Use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to open the input field for Copilot.
     - Type the following prompt:
       ```plaintext
       Create a REST controller in .NET 8 with a GET endpoint /hello that returns "Hello, Copilot!"
       ```
   - Accept Copilot’s suggestions to generate the necessary code. 

2. **Test the Generated Code**:
   - Run the projet `Tasks` class to start your .NET application.
    ```
      cd 01 - Exercise/Exercise
      dotnet run
    ```
   - Use a browser or tool like Postman/Bruno to access the endpoint:
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
- How to create a REST API endpoint in .NET 8.

---

### Additional Challenges
1. Modify the `/hello` endpoint to include your name, e.g., `"Hello, [Your Name]! Copilot loves your work!"`.
2. Add a new endpoint `/goodbye` that returns `"Goodbye, Copilot!"`.
3. Experiment with prompting Copilot to add comments to explain the generated code.

---

### Troubleshooting
- **Port Already in Use**:  
  If the application fails to start, check if another application is using port `8080` or modify the port in `properties\launchSettings.json`.

---

### Using GitHub Copilot Efficiently
- **Prompt Suggestions**: Write clear, concise prompts to get the best results from Copilot. For example:
  - `"Create a REST API endpoint in .NET 8 that responds to GET /hello with a message 'Hello, Copilot!'."`
  - `"Add a GET request for /api/task1/hello in a .NET 8 REST controller."`
- **Experiment**: Try different prompts and observe how Copilot adapts its suggestions. You could try to add the endpoint section

---

### Next Steps
After completing this task, proceed to **Task 2**, where you will learn how to handle request parameters to make your endpoints more dynamic.