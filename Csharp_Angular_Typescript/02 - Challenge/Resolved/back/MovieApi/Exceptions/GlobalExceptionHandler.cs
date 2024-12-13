
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;

namespace MovieApi.Exceptions
{
    public class GlobalExceptionHandler : ExceptionFilterAttribute
    {
        public override void OnException(ExceptionContext context)
        {
            if (context.Exception is DbUpdateConcurrencyException)
            {
                context.Result = new ConflictObjectResult("The movie was updated or deleted by another transaction");
            }
            else
            {
                context.Result = new ObjectResult("An unexpected error occurred")
                {
                    StatusCode = 500
                };
            }
        }
    }
}