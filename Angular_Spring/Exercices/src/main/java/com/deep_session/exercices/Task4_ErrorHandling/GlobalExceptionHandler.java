package com.deep_session.exercices.Task4_ErrorHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions related to invalid date formats.
     * @param ex the exception thrown when parsing dates
     * @return a response with a bad request status and a descriptive error message
     */
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> handleDateParseException(DateTimeParseException ex) {
        return ResponseEntity.badRequest().body("Invalid date format: " + ex.getMessage());
    }

    /**
     * Handles NullPointerExceptions globally.
     * @param ex the NullPointerException thrown
     * @return a response with an internal server error status and a descriptive error message
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        return ResponseEntity.internalServerError().body("A null value was encountered: " + ex.getMessage());
    }

    /**
     * Handles all other exceptions.
     * @param ex the exception
     * @return a response with an internal server error status and a generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.internalServerError().body("An error occurred: " + ex.getMessage());
    }
}
