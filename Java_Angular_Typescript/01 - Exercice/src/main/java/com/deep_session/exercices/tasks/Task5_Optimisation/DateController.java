package com.deep_session.exercices.tasks.Task5_Optimisation;

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
@RequestMapping("/api/task5")
public class DateController {

  @GetMapping("/days-between")
  public ResponseEntity<?> daysBetween(
      @RequestParam(required = false) String startDate,
      @RequestParam(required = false) String endDate) {

    if (startDate == null || endDate == null) {
      return ResponseEntity.badRequest().body("Both startDate and endDate must be provided.");
    }

    try {
      LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
      LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

      if (start.isBefore(end)) {
        return ResponseEntity.badRequest().body("startDate cannot be before endDate.");
      }

      long daysBetween = ChronoUnit.DAYS.between(start, end);
      return ResponseEntity.ok(daysBetween);
    } catch (DateTimeParseException e) {
      return ResponseEntity.badRequest().body("Invalid date format. Use yyyy-MM-dd.");
    }
  }

  @GetMapping("/weeks-between")
  public ResponseEntity<?> weeksBetween(
      @RequestParam(required = false) String startDate,
      @RequestParam(required = false) String endDate) {

    if (startDate == null || endDate == null) {
      return ResponseEntity.badRequest().body("Both startDate and endDate must be provided.");
    }

    try {
      LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
      LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

      if (start.isAfter(end)) {
        return ResponseEntity.badRequest().body("startDate cannot be after endDate.");
      }

      long weeksBetween = ChronoUnit.WEEKS.between(start, end);
      return ResponseEntity.ok(weeksBetween);
    } catch (DateTimeParseException e) {
      return ResponseEntity.badRequest().body("Invalid date format. Use yyyy-MM-dd.");
    }
  }

  @GetMapping("/is-past-date")
  public ResponseEntity<?> isPastDate(@RequestParam(required = false) String date) {
    if (date == null) {
      return ResponseEntity.badRequest().body("Date must be provided.");
    }

    try {
      LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
      if (parsedDate.isBefore(LocalDate.now())) {
        return ResponseEntity.ok("The date is in the past.");
      } else {
        return ResponseEntity.ok("The date is not in the past.");
      }
    } catch (DateTimeParseException e) {
      return ResponseEntity.badRequest().body("Invalid date format. Use yyyy-MM-dd.");
    }
  }

  @GetMapping("/is-weekend")
  public ResponseEntity<?> isWeekend(@RequestParam(required = false) String date) {
    if (date == null) {
      return ResponseEntity.badRequest().body("Date must be provided.");
    }

    try {
      LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
      int dayOfWeek = parsedDate.getDayOfWeek().getValue();

      if (dayOfWeek == 6 || dayOfWeek == 7) {
        return ResponseEntity.ok("The date is a weekend.");
      } else {
        return ResponseEntity.ok("The date is not a weekend.");
      }
    } catch (DateTimeParseException e) {
      return ResponseEntity.badRequest().body("Invalid date format. Use yyyy-MM-dd.");
    }
  }
}
