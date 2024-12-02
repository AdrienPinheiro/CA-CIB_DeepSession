using Microsoft.AspNetCore.Mvc;
using System;
using System.Globalization;

namespace Tasks.Task3;

[ApiController]
[Route("api/task3")]
public class Task3DaysBetweenController : ControllerBase
{
    private readonly ILogger<Task3DaysBetweenController> _logger;

    public Task3DaysBetweenController(ILogger<Task3DaysBetweenController> logger)
    {
        _logger = logger;
    }

    [HttpGet("days-between")]
    public IActionResult DaysBetween([FromQuery] string startDate, [FromQuery] string endDate)
    {
        try
        {
            var start = DateTime.ParseExact(startDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var end = DateTime.ParseExact(endDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);

            if (start > end)
            {
                return BadRequest("startDate cannot be after endDate");
            }

            var days = (end - start).TotalDays;
            return Ok(days);
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    [HttpGet("is-past-date")]
    public IActionResult IsPastDate([FromQuery] string date)
    {
        try
        {
            var parsedDate = DateTime.ParseExact(date, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var isPast = parsedDate < DateTime.Now;
            return Ok(isPast ? "The date is in the past." : "The date is not in the past.");
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    [HttpGet("weeks-between")]
    public IActionResult WeeksBetween([FromQuery] string startDate, [FromQuery] string endDate)
    {
        try
        {
            var start = DateTime.ParseExact(startDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var end = DateTime.ParseExact(endDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);

            if (start > end)
            {
                return BadRequest("startDate cannot be after endDate");
            }

            var weeks = (end - start).TotalDays / 7;
            return Ok(weeks);
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    [HttpGet("is-weekend")]
    public IActionResult IsWeekend([FromQuery] string date)
    {
        try
        {
            var parsedDate = DateTime.ParseExact(date, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var isWeekend = parsedDate.DayOfWeek == DayOfWeek.Saturday || parsedDate.DayOfWeek == DayOfWeek.Sunday;
            return Ok(isWeekend ? "The date is a weekend." : "The date is not a weekend.");
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use YYYY-MM-DD.");
        }
    }
}
