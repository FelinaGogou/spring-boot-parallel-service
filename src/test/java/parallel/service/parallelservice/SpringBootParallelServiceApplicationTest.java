package parallel.service.parallelservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = SpringBootParallelServiceApplication.class)
class SpringBootParallelServiceApplicationTest {

	@Test
	void contextLoads() {
		var context = SpringApplication.run(SpringBootParallelServiceApplication.class);

		assertNotNull(context);
		context.close();
	}
}