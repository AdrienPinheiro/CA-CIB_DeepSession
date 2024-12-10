using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;
using Moq;
using MovieApi.Exceptions;
using Xunit;
using SystemException = System.Exception;
using System.Collections.Generic;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Routing;
using Microsoft.AspNetCore.Mvc.Abstractions;

namespace MovieApi.Tests.Exceptions
{
    public class GlobalExceptionHandlerTests
    {
        [Fact]
        public void OnException_DbUpdateConcurrencyException_ReturnsConflictResult()
        {
            // Arrange
            // Create a new instance of the GlobalExceptionHandler class
            var exceptionHandler = new GlobalExceptionHandler();
            // Create a new instance of the DefaultHttpContext class
            var httpContext = new DefaultHttpContext();
            // Create a new instance of the ExceptionContext class
            var context = new ExceptionContext(
                new ActionContext(httpContext, new RouteData(), new ActionDescriptor()), 
                new List<IFilterMetadata>()
            )
            {
                // Set the Exception property to a new instance of the DbUpdateConcurrencyException class
                Exception = new DbUpdateConcurrencyException()
            };

            // Act
            // Call the OnException method of the exceptionHandler object
            exceptionHandler.OnException(context);

            // Assert
            // Assert that the Result property of the context object is of type ConflictObjectResult
            var result = Assert.IsType<ConflictObjectResult>(context.Result);
            // Assert that the Value property of the result object is equal to "The movie was updated or deleted by another transaction"
            Assert.Equal("The movie was updated or deleted by another transaction", result.Value);
        }

        [Fact]
        public void OnException_OtherException_ReturnsInternalServerError()
        {
            // Arrange
            var exceptionHandler = new GlobalExceptionHandler();
            var httpContext = new DefaultHttpContext();
            var context = new ExceptionContext(
                new ActionContext(httpContext, new RouteData(), new ActionDescriptor()), 
                new List<IFilterMetadata>()
            )
            {
                Exception = new SystemException()
            };

            // Act
            exceptionHandler.OnException(context);

            // Assert
            // Assert that the Result property of the context object is of type ObjectResult
            var result = Assert.IsType<ObjectResult>(context.Result);
            // Assert that the StatusCode property of the result object is equal to 500
            Assert.Equal(500, result.StatusCode);
            // Assert that the Value property of the result object is equal to "An unexpected error occurred"
            Assert.Equal("An unexpected error occurred", result.Value);
        }
    }
}