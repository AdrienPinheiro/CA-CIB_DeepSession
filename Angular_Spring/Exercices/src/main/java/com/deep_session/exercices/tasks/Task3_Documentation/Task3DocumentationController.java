package com.deep_session.exercices.tasks.Task3_Documentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


@RestController
@RequestMapping("/api/task3")
public class Task3DocumentationController {

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

    @GetMapping("/is-past-date")
    public ResponseEntity<String> isPastDate(@RequestParam String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            boolean isPast = parsedDate.isBefore(LocalDate.now());
            return ResponseEntity.ok(isPast ? "The date is in the past." : "The date is not in the past.");
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    @GetMapping("/weeks-between")
    public ResponseEntity<?> weeksBetween(
        @RequestParam String startDate,
        @RequestParam String endDate
    ) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);

            if (start.isAfter(end)) {
                return ResponseEntity.badRequest().body("startDate cannot be after endDate");
            }

            long weeks = ChronoUnit.WEEKS.between(start, end);
            return ResponseEntity.ok(weeks);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    @GetMapping("/is-weekend")
    public ResponseEntity<String> isWeekend(@RequestParam String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            boolean isWeekend = parsedDate.getDayOfWeek().getValue() == 6 || parsedDate.getDayOfWeek().getValue() == 7;
            return ResponseEntity.ok(isWeekend ? "The date is a weekend." : "The date is not a weekend.");
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }
    }
}
