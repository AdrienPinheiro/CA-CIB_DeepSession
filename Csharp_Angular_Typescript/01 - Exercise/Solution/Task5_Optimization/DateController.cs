using Microsoft.AspNetCore.Mvc;
using System.Globalization;

namespace Task5Optimisation.Controllers;

[ApiController]
[Route("api/solution/task5")]
public class DateController : ControllerBase
{
    [HttpGet("days-between")]
    public IActionResult DaysBetween([FromQuery] string startDate, [FromQuery] string endDate)
    {
        if (string.IsNullOrEmpty(startDate) || string.IsNullOrEmpty(endDate))
        {
            return BadRequest("Both startDate and endDate must be provided.");
        }

        try
        {
            var start = DateTime.ParseExact(startDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var end = DateTime.ParseExact(endDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);

            if (start > end)
            {
                return BadRequest("startDate cannot be after endDate.");
            }

            var daysBetween = (end - start).TotalDays;
            return Ok(daysBetween);
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use yyyy-MM-dd.");
        }
    }

    [HttpGet("weeks-between")]
    public IActionResult WeeksBetween([FromQuery] string startDate, [FromQuery] string endDate)
    {
        if (string.IsNullOrEmpty(startDate) || string.IsNullOrEmpty(endDate))
        {
            return BadRequest("Both startDate and endDate must be provided.");
        }

        try
        {
            var (start, end) = ParseDates(startDate, endDate);

            if (start > end)
            {
                return BadRequest("startDate cannot be after endDate.");
            }

            var weeksBetween = (end - start).TotalDays / 7;
            return Ok(weeksBetween);
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use yyyy-MM-dd.");
        }
    }

    private (DateTime start, DateTime end) ParseDates(string startDate, string endDate)
    {
        var start = DateTime.ParseExact(startDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);
        var end = DateTime.ParseExact(endDate, "yyyy-MM-dd", CultureInfo.InvariantCulture);
        return (start, end);
    }

    [HttpGet("is-past-date")]
    public IActionResult IsPastDate([FromQuery] string date)
    {
        if (string.IsNullOrEmpty(date))
        {
            return BadRequest("Date must be provided.");
        }

        try
        {
            var parsedDate = DateTime.ParseExact(date, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            return Ok(parsedDate < DateTime.Now ? "The date is in the past." : "The date is not in the past.");
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use yyyy-MM-dd.");
        }
    }

    [HttpGet("is-weekend")]
    public IActionResult IsWeekend([FromQuery] string date)
    {
        if (string.IsNullOrEmpty(date))
        {
            return BadRequest("Date must be provided.");
        }

        try
        {
            var parsedDate = DateTime.ParseExact(date, "yyyy-MM-dd", CultureInfo.InvariantCulture);
            var isWeekend = parsedDate.DayOfWeek == DayOfWeek.Saturday || parsedDate.DayOfWeek == DayOfWeek.Sunday;
            return Ok(isWeekend ? "The date is a weekend." : "The date is not a weekend.");
        }
        catch (FormatException)
        {
            return BadRequest("Invalid date format. Use yyyy-MM-dd.");
        }
    }
}