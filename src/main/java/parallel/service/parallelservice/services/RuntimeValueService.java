package parallel.service.parallelservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The RuntimeValueService class is an implementation of the ValueService interface
 * that retrieves a runtime value based on a configuration property.
 */
@Service
public class RuntimeValueService implements ValueService {

    @Value("${runtime.value:default}")
    private String value;

    /**
     * Retrieves the runtime value.
     *
     * @return The runtime value as a String.
     */
    @Override
    public String getValue() {
        return value;
    }
}
