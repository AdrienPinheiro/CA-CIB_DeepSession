using Microsoft.AspNetCore.Mvc;
using System;
using System.Globalization;

namespace Tasks.Task2;

[ApiController]
[Route("api/task2")]
public class Task2DaysBetweenController : ControllerBase
{
    private readonly ILogger<Task2DaysBetweenController> _logger;

    public Task2DaysBetweenController(ILogger<Task2DaysBetweenController> logger)
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
                throw new FormatException("startDate cannot be after endDate");
            }

            var days = (int)(end - start).TotalDays;
            return Ok(days);
        }
        catch (FormatException)
        {
            throw new FormatException("Invalid date format. Use YYYY-MM-DD.");
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
            throw new FormatException("Invalid date format. Use YYYY-MM-DD.");
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
                throw new FormatException("startDate cannot be after endDate");
            }

            var weeks = (int)((end - start).TotalDays / 7);
            return Ok(weeks);
        }
        catch (FormatException)
        {
            throw new FormatException("Invalid date format. Use YYYY-MM-DD.");
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
            throw new FormatException("Invalid date format. Use YYYY-MM-DD.");
        }
    }
}
