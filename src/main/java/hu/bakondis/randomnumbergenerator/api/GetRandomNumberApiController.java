package hu.bakondis.randomnumbergenerator.api;

import hu.bakondis.randomnumbergenerator.service.Generator;
import hu.bakondis.randomnumbergenerator.model.RandomNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GetRandomNumberApiController implements GetRandomNumberApi {

    private static final Logger log = LoggerFactory.getLogger(GetRandomNumberApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private Generator generator;

    @org.springframework.beans.factory.annotation.Autowired
    public GetRandomNumberApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<RandomNumber> getRandomNumber(@Parameter(in = ParameterIn.PATH, description = "the minimum number", required = true, schema = @Schema()) @PathVariable("minNumber") Long minNumber,
                                                        @Parameter(in = ParameterIn.PATH, description = "the maximum number", required = true, schema = @Schema()) @PathVariable("maxNumber") Long maxNumber) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                RandomNumber response = new RandomNumber();
                response.setMinNumber(minNumber);
                response.setMaxNumber(maxNumber);
                response.setRandomNumber(generator.getRandom(minNumber, maxNumber));

                return new ResponseEntity<RandomNumber>(response, HttpStatus.OK);
            } catch (RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RandomNumber>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RandomNumber>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public String healthCheck() {
        return "OK";
    }
}
