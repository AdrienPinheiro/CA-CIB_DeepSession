using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System;

namespace Tasks.Task4;

public class GlobalExceptionHandlerSolution : IExceptionFilter
{
    public void OnException(ExceptionContext context)
    {
      var exceptionType = context.Exception.GetType();
      var message = context.Exception.Message;
      context.Result = HandleException(exceptionType, message);
    }

    private ObjectResult HandleException(Type exceptionType, string message)
    {
      return exceptionType switch
      {
        Type t when t == typeof(FormatException) => HandleFormatException(message),
        Type t when t == typeof(NullReferenceException) => HandleNullReferenceException(message),
        _ => HandleGenericException(message),
      };
    }
    
    private ObjectResult HandleFormatException(string message)
    {
      return new BadRequestObjectResult("Message : " + message);
    }

    private ObjectResult HandleNullReferenceException(string message)
    {
      return new ObjectResult("A null value was encountered: " + message) { StatusCode = 500 };
    }

    private ObjectResult HandleGenericException(string message)
    {
      return new ObjectResult("An error occurred: " + message) { StatusCode = 500 };
    }
}
