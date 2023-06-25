package parallel.service.parallelservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrentDayServiceTest {
    private CurrentDayService currentDayService;
    @BeforeEach
    public void setUp() {
        currentDayService = new CurrentDayService();
    }

    @Test
    void getCurrentDayName_returnsCorrectDayName() {
        // Given
        var currentLocalDate = LocalDate.of(2010, 2, 13);
        try (var topDateTimeUtilMock = Mockito.mockStatic(LocalDate.class)) {
            // When
            topDateTimeUtilMock.when(LocalDate::now).thenReturn(currentLocalDate);

            // Then
            assertEquals(currentLocalDate.getDayOfWeek().name(), currentDayService.getCurrentDayName());
        }
    }
}
