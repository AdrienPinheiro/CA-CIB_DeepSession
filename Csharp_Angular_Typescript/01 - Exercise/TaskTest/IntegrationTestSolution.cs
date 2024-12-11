using Microsoft.Extensions.Logging;
using Microsoft.AspNetCore.Mvc;
using TasksSolution.Task2;

namespace TaskTest;

public class IntegrationTestSolution
{
    private readonly Task2DaysBetweenController _controller;

    public IntegrationTestSolution()
    {
        var logger = new LoggerFactory().CreateLogger<Task2DaysBetweenController>();
        _controller = new Task2DaysBetweenController(logger);
    }

    [Fact]
    public void TestDaysBetween_ValidDates()
    {
        var result = _controller.DaysBetween("2023-01-01", "2023-01-10") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal(9, (int)result.Value); // Cast to int for comparison
    }

    [Fact]
    public void TestDaysBetween_InvalidDateFormat()
    {
        var result = Assert.Throws<FormatException>(() => _controller.DaysBetween("2023-01-01", "invalid-date"));
        Assert.Equal("Invalid date format. Use YYYY-MM-DD.", result.Message);
    }

    [Fact]
    public void TestIsPastDate_PastDate()
    {
        var result = _controller.IsPastDate("2020-01-01") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal("The date is in the past.", result.Value);
    }

    [Fact]
    public void TestIsPastDate_FutureDate()
    {
        var result = _controller.IsPastDate("2100-01-01") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal("The date is not in the past.", result.Value);
    }

    [Fact]
    public void TestWeeksBetween_ValidDates()
    {
        var result = _controller.WeeksBetween("2023-01-01", "2023-01-15") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal(2, result.Value);
    }

    [Fact]
    public void TestIsWeekend_WeekendDate()
    {
        var result = _controller.IsWeekend("2023-01-07") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal("The date is a weekend.", result.Value);
    }

    [Fact]
    public void TestIsWeekend_WeekdayDate()
    {
        var result = _controller.IsWeekend("2023-01-09") as OkObjectResult;
        Assert.NotNull(result);
        Assert.Equal("The date is not a weekend.", result.Value);
    }
}