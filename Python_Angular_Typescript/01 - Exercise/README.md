# **Deep Session Exercises - Python FastAPI**

This repository contains a series of self-contained tasks designed to help developers practice and enhance their skills using **GitHub Copilot** and **FastAPI**. Each task is an independent project with its own **instructions**, **starter code**, **solutions**, and **dependencies**.

---

## **Project Structure**

The repository is structured as follows:

```plaintext
src/
├── Task1_Hello/
│   ├── main.py                 # Entry point for Task 1 (starter code)
│   ├── README.md               # Instructions for Task 1
│   ├── solution.py             # Fully implemented solution for Task 1
│   └── requirements.txt        # Dependencies for Task 1
├── Task2_Example/
│   ├── main.py                 # Entry point for Task 2 (starter code)
│   ├── README.md               # Instructions for Task 2
│   ├── solution.py             # Fully implemented solution for Task 2
│   └── requirements.txt        # Dependencies for Task 2
└── ...                         # Additional tasks
```

---

## **How to Run Each Exercise**

Each task is a standalone FastAPI application. Follow these steps to set up and run any task:

### **1. Prerequisites**
- Ensure **Python 3.10 or higher** is installed on your system:
  ```bash
  python --version
  ```
  If not installed, download it from the [official Python website](https://www.python.org/downloads/).

- Install **pip**, Python's package manager (usually included with Python).

- **Use a Virtual Environment**:
  It’s highly recommended to create a virtual environment for each task to avoid dependency conflicts:
  ```bash
  python -m venv venv
  source venv/bin/activate    # On Linux/Mac
  venv\Scripts\activate       # On Windows
  ```

### **2. Navigate to the Task Directory**
Each task is located in its own folder under `src/`. For example, to start **Task 1**:
```bash
cd src/Task1_Hello
```

### **3. Install Dependencies**
Install the dependencies listed in the `requirements.txt` file for the task:
```bash
pip install -r requirements.txt
```

### **4. Run the Application**
Start the FastAPI application using `uvicorn`:
```bash
uvicorn main:app --reload
```

### **5. Access the Endpoints**
Use a web browser or a tool like Postman to interact with the API. The default server URL is:
```
http://127.0.0.1:8000
```

Refer to the **README.md** file in each task directory for specific endpoints and usage instructions.

---

## **How to Use the Repository**

1. **Start with the Exercises**:
   - Each task contains a `README.md` with detailed instructions.
   - The `main.py` file serves as the starting point.

2. **Use GitHub Copilot**:
   - Use Copilot to scaffold and enhance the code in `main.py`.

3. **Check the Solutions**:
   - If you're stuck or want to compare your work, review the fully implemented solution in `solution.py`.

---

## **What You’ll Learn**
- How to use **GitHub Copilot** to scaffold and enhance code.
- How to build RESTful APIs using **FastAPI**.
- Modular programming and organizing Python projects.

---

## **Next Steps**
After completing a task, you can:
- Explore the **Additional Challenges** mentioned in the task’s `README.md`.
- Move to the next task in the series.
- Review the FastAPI documentation for deeper insights: [https://fastapi.tiangolo.com](https://fastapi.tiangolo.com).

---

## **Troubleshooting**
- **Virtual Environment Not Activating**:
  - Ensure you’ve installed Python correctly.
  - Use `python3` or `py` instead of `python` if needed.

- **Dependencies Not Installing**:
  - Check your internet connection.
  - Ensure you’re in the correct directory and the virtual environment is active.

- **Port Already in Use**:
  - If `8000` is in use, run the application on a different port:
    ```bash
    uvicorn main:app --reload --port 8001
    ```

---

This updated structure includes **solutions** for each task, making it easy for developers to check their progress and compare their work with the expected implementation.