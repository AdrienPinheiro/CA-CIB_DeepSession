package com.deep_session.exercices.solutions.Task3_Documentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/solution/task3")
public class Task3DocumentationControllerSolution {

    /**
     * Calculates the number of days between two dates.
     * @param startDate the start date in ISO format (yyyy-MM-dd)
     * @param endDate the end date in ISO format (yyyy-MM-dd)
     * @return the number of days between the two dates
     */
    @GetMapping("/days-between")
    public ResponseEntity<?> daysBetween(
        @RequestParam String startDate,
        @RequestParam String endDate
    ) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);

            if (start.isAfter(end)) {
                return ResponseEntity.badRequest().body("startDate cannot be after endDate");
            }

            long days = ChronoUnit.DAYS.between(start, end);
            return ResponseEntity.ok(days);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }
    }
}
