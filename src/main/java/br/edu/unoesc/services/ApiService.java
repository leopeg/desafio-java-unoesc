package br.edu.unoesc.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.entities.RandomFact;

@Service
public class ApiService {
	
	public String getRandomFacts() {
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		RandomFact randomFact = restTemplate.getForObject(uri, RandomFact.class);
		
		return (randomFact != null) ? randomFact.getText() : "Nenhum fato aleatório!";
	}
}