package br.edu.unoesc.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RandomFacts {

	@GetMapping(value = "/randomFacts")
	private String getRandomFacts() {
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
}