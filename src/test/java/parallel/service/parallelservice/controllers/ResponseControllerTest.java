package parallel.service.parallelservice.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import parallel.service.parallelservice.services.DayService;
import parallel.service.parallelservice.services.ValueService;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ResponseControllerTest {
    @Mock
    private ValueService valueService;
    @Mock
    private DayService dayService;

    private ResponseController responseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        responseController = new ResponseController(valueService, dayService);
    }

    @Test
    void getCombinedResponse_returnsCombinedResponse() throws InterruptedException, ExecutionException {
        // Given
        var value = "testValue";
        var dayName = "Monday";

        when(valueService.getValue()).thenReturn(value);
        when(dayService.getCurrentDayName()).thenReturn(dayName);

        var expectedResponse = ResponseEntity.ok(value + " - " + dayName);

        // When
        var actualResponse = responseController.getCombinedResponse();

        // Then
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}
