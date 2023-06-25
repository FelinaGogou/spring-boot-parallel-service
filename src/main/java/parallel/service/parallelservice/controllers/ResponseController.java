package parallel.service.parallelservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parallel.service.parallelservice.services.DayService;
import parallel.service.parallelservice.services.ValueService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@RestController
public class ResponseController {
    private final ValueService valueService;
    private final DayService dayService;

    /**
     * Constructs a ResponseController with the specified value and day services.
     *
     * @param valueService the value service
     * @param dayService   the day service
     */
    public ResponseController(ValueService valueService, DayService dayService) {
        this.valueService = valueService;
        this.dayService = dayService;
    }

    /**
     * Retrieves the combined response from the value and day services.
     *
     * @return the combined response
     * @throws InterruptedException if the current thread is interrupted while waiting
     * @throws ExecutionException   if an error occurs during the execution of the CompletableFuture
     */
    @GetMapping("/combined")
    public ResponseEntity<String> getCombinedResponse() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(2);
        var valueFuture = CompletableFuture.supplyAsync(valueService::getValue, executor);
        var dayFuture = CompletableFuture.supplyAsync(dayService::getCurrentDayName, executor);

        CompletableFuture.allOf(valueFuture, dayFuture).join();

        var combinedResponse = valueFuture.get() + " - " + dayFuture.get();

        return ResponseEntity.ok(combinedResponse);
    }
}
