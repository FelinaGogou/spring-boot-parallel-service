package parallel.service.parallelservice.services;


import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * The CurrentDayService class is an implementation of the DayService interface
 * that retrieves the name of the current day based on the system's local date.
 */
@Service
public class CurrentDayService implements DayService {

    /**
     * Retrieves the name of the current day.
     *
     * @return The name of the current day as a String.
     */
    @Override
    public String getCurrentDayName() {
        var currentDate = LocalDate.now();
        return currentDate.getDayOfWeek().name();
    }
}