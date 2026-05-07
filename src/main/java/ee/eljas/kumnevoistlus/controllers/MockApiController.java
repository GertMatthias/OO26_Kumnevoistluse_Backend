package ee.eljas.kumnevoistlus.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class MockApiController {

    private final String mockApiUrl = "https://69fd077830ad0a6fd1c06b2d.mockapi.io";

    @GetMapping("/decathlon/judges")
    public String getJudges() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                mockApiUrl + "/judges",
                String.class
        );
    }

    @GetMapping("/decathlon/locations")
    public String getLocations() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                mockApiUrl + "/locations",
                String.class
        );
    }
}