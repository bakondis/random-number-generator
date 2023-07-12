package hu.bakondis.randomnumbergenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.bakondis.randomnumbergenerator.model.RandomNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneratorTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    private static final int MIN_VALUE = 12;
    private static final int MAX_VALUE = 15;

    @Test
    public void getRandomNumber() throws Exception {

        String result = this.restTemplate.getForObject(String.format("http://localhost:%d/getRandomNumber/%d/%d", port, MIN_VALUE, MAX_VALUE ), String.class);

        RandomNumber randomNumber = mapper.readValue(result, RandomNumber.class);

        assertTrue(randomNumber.getRandomNumber() >= MIN_VALUE && randomNumber.getRandomNumber() <= MAX_VALUE);
    }
}
