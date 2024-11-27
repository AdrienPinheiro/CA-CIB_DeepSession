package com.deep_session.exercices.solutions.Task5_Optimisation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/solution")
public class DateController {

    /**
     * Validates the provided dates and ensures they are not null and follow the correct format.
     * @param startDate the start date in ISO format (yyyy-MM-dd)
     * @param endDate the end date in ISO format (yyyy-MM-dd)
     * @return a ResponseEntity with an error message if validation fails, or null if validation passes
     */
    private ResponseEntity<String> validateDates(String startDate, String endDate) {
        if (startDate == null || endDate == null) {
            return ResponseEntity.badRequest().body("Both startDate and endDate must be provided.");
        }
        return null;
    }

    /**
     * Calculates the number of days between two dates with refactored code for better readability.
     * @param startDate the start date
     * @param endDate the end date
     * @return the number of days between the start and end dates
     */
    @GetMapping("/days-between-refactored")
    public ResponseEntity<?> daysBetweenRefactored(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        // Validate input dates
        ResponseEntity<String> validationResponse = validateDates(startDate, endDate);
        if (validationResponse != null) return validationResponse;

        try {
            LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (start.isAfter(end)) {
                return ResponseEntity.badRequest().body("startDate must be before endDate.");
            }

            return ResponseEntity.ok(ChronoUnit.DAYS.between(start, end));
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use 'yyyy-MM-dd'.");
        }
    }

    /**
     * Utility method to validate and parse dates with added DRY principle.
     * @param date the date to validate and parse
     * @param isStartDate whether the date is the start date
     * @return true if the date is valid for its context, false otherwise
     */
    public boolean validateDate(String date, boolean isStartDate) {
        LocalDate parsedDate = LocalDate.parse(date);
        return isStartDate ? parsedDate.isBefore(LocalDate.now()) : parsedDate.isAfter(LocalDate.now());
    }
}
