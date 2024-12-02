using Microsoft.AspNetCore.Mvc;

namespace Tasks.Task1;

[ApiController]
[Route("api/task1")]
public class Task1HelloController : ControllerBase
{
    private readonly ILogger<Task1HelloController> _logger;

    public Task1HelloController(ILogger<Task1HelloController> logger)
    {
        _logger = logger;
    }

    [HttpGet("hello")]
    public IActionResult GetHelloWorld()
    {
        _logger.LogInformation("Hello world endpoint was called.");
        return Ok("Hello, World!");
    }

}
