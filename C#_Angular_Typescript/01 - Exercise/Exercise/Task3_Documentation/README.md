# Task 3: Documentation and Automatic API Generation
### Objective
Learn how to document REST API endpoints using comments and generate interactive API documentation using **Swagger**.

---

### Task Description
1. **Add XML comments to your REST endpoints**:
   - Use **GitHub Copilot** to automatically generate comments for the endpoints.
   - Comments should describe the method's functionality, parameters, and return values.

2. **Set Up Swagger**:
   - Configure your project to use **Swagger** for automatic API documentation.
   - Test your documentation using the Swagger UI.

---

### File Structure
```plaintext
Exercise/
    └── Task3_Documentation/
          └── Task3DocumentationController.cs
```

---

### Step-by-Step Instructions

#### **Part 1: Add XML Comments**

1. **Use GitHub Copilot to Add XML Comments**:
   - Open `Task3DocumentationController.cs`.
   - For each method, place your cursor above the method declaration.
   - Use **Ctrl+I (Windows/Linux)** or **Cmd+I (Mac)** to open the Copilot prompt. Use the command `/doc` to generate XML comments.
   - Accept the suggested XML comments.

#### **Part 2: Configure Swagger**

1. **Add Swagger Dependency**:
   - Open the chat window and **ask Github Copilot** : How it can help you add swagger inside the project ?. You will need to tag `@workspace` to give your assistant access to the project files and provide context file like i.e : `program.cs` or `csproj` file.
  
<details>
<summary>Possible Flow</summary>  

1. Open your `csproj` file and add the following package reference:
    ```xml
    <PackageReference Include="Swashbuckle.AspNetCore" Version="6.2.3" />
    ```

2. Open `Program.cs` and add the following configuration:
    ```csharp
    var builder = WebApplication.CreateBuilder(args);

    // Add services to the container.
    builder.Services.AddControllers();
    builder.Services.AddEndpointsApiExplorer();
    builder.Services.AddSwaggerGen();

    var app = builder.Build();

    // Configure the HTTP request pipeline.
    if (app.Environment.IsDevelopment())
   {
      app.UseSwagger();
      app.UseSwaggerUI(c =>
      {
         c.SwaggerEndpoint("/swagger/v1/swagger.json", "My API V1");
         c.RoutePrefix = string.Empty; // Set Swagger UI at the app's root
      });
   }

    app.UseHttpsRedirection();
    app.UseAuthorization();
    app.MapControllers();
    app.Run();
    ```
3. **Access Swagger UI**:
   - Run your .NET application.
   - Open your browser and go to:  
     ```
     http://localhost:5000/index.html
     ```
</details>

---

### **What You’ll Learn**
- How to use **GitHub Copilot** to document code automatically.
- The importance of documenting API endpoints to facilitate collaboration and integration.
- How to generate and test interactive API documentation using Swagger.

---

### **Discussion Points**

1. **Why Document APIs?**
   - Ensures clarity for future developers.
   - Simplifies integration for external teams.
   - Acts as a contract between API developers and consumers.

2. **Swagger and Team Collaboration**:
   - Swagger UI provides an interactive interface for testing APIs.
   - Helps non-developers (e.g., QA teams, product managers) understand API capabilities.

---

### Additional Challenges
1. Add custom error messages to the Swagger documentation for validation errors.
2. Explore how to secure the Swagger UI using ASP.NET Core Identity.
3. Experiment with generating API client code using the OpenAPI specification.
