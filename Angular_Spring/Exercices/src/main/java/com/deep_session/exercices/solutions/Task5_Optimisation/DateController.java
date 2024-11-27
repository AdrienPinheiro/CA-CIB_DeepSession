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
@RequestMapping("/api")
public class DateController {

    /**
     * Validates the input dates for null values and proper ISO format.
     *
     * @param date the date string to validate
     * @return the parsed LocalDate if valid
     * @throws IllegalArgumentException if the date is null or invalid
     */
    private LocalDate validateDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must be provided.");
        }
        try {
            return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd.");
        }
    }

    /**
     * Validates the start and end dates for proper order and formatting.
     *
     * @param startDate the start date string
     * @param endDate   the end date string
     * @return an array containing parsed start and end dates
     */
    private LocalDate[] validateAndParseDates(String startDate, String endDate) {
        LocalDate start = validateDate(startDate);
        LocalDate end = validateDate(endDate);

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("startDate cannot be after endDate.");
        }
        return new LocalDate[]{start, end};
    }

    @GetMapping("/days-between")
    public ResponseEntity<?> getDaysBetween(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            LocalDate[] dates = validateAndParseDates(startDate, endDate);
            long daysBetween = ChronoUnit.DAYS.between(dates[0], dates[1]);
            return ResponseEntity.ok(daysBetween);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/weeks-between")
    public ResponseEntity<?> getWeeksBetween(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            LocalDate[] dates = validateAndParseDates(startDate, endDate);
            long weeksBetween = ChronoUnit.WEEKS.between(dates[0], dates[1]);
            return ResponseEntity.ok(weeksBetween);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/is-past-date")
    public ResponseEntity<?> isPastDate(@RequestParam String date) {
        try {
            LocalDate parsedDate = validateDate(date);
            boolean isPast = parsedDate.isBefore(LocalDate.now());
            return ResponseEntity.ok(isPast ? "The date is in the past." : "The date is not in the past.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/is-weekend")
    public ResponseEntity<?> isWeekend(@RequestParam String date) {
        try {
            LocalDate parsedDate = validateDate(date);
            int dayOfWeek = parsedDate.getDayOfWeek().getValue();
            boolean isWeekend = (dayOfWeek == 6 || dayOfWeek == 7);
            return ResponseEntity.ok(isWeekend ? "The date is a weekend." : "The date is not a weekend.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
