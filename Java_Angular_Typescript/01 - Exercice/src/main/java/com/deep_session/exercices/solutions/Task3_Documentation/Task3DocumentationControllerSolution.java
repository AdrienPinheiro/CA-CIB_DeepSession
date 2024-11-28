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
   *
   * @param startDate the start date in YYYY-MM-DD format
   * @param endDate   the end date in YYYY-MM-DD format
   * @return a ResponseEntity containing the number of days between the two dates,
   *         or an error message if the dates are invalid or if startDate is after
   *         endDate
   */
  @GetMapping("/days-between")
  public ResponseEntity<?> daysBetween(
      @RequestParam String startDate,
      @RequestParam String endDate) {
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

  /**
   * Checks if the provided date is in the past.
   *
   * @param date the date to check in the format YYYY-MM-DD
   * @return a ResponseEntity containing a message indicating whether the date is
   *         in the past or not.
   *         If the date format is invalid, returns a bad request response with an
   *         error message.
   */
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

  /**
   * Calculates the number of weeks between two dates.
   *
   * @param startDate the start date in the format YYYY-MM-DD
   * @param endDate   the end date in the format YYYY-MM-DD
   * @return a ResponseEntity containing the number of weeks between the two
   *         dates,
   *         or an error message if the dates are invalid or if the start date is
   *         after the end date
   */
  @GetMapping("/weeks-between")
  public ResponseEntity<?> weeksBetween(
      @RequestParam String startDate,
      @RequestParam String endDate) {
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

  /**
   * Checks if the given date is a weekend.
   *
   * @param date the date to check in the format YYYY-MM-DD
   * @return a ResponseEntity containing a message indicating whether the date is
   *         a weekend or not
   * @throws DateTimeParseException if the date format is invalid
   */
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
