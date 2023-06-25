package parallel.service.parallelservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuntimeValueServiceTest {
    private RuntimeValueService runtimeValueService;

    @BeforeEach
    public void setUp() {
        runtimeValueService = new RuntimeValueService();
    }

    @Test
    void getValue_returnsRuntimeValue() {
        // Given
        String runtimeValue = "runtime";
        ReflectionTestUtils.setField(runtimeValueService, "value", runtimeValue);

        // When
        String actualValue = runtimeValueService.getValue();

        // Then
        assertEquals(runtimeValue, actualValue);
    }
}
