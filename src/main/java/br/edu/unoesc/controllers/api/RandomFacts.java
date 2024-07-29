package br.edu.unoesc.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.entities.RandomFact;
import br.edu.unoesc.repositories.PessoaRepository;

@Controller
public class RandomFacts {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping("/randomFacts")
	public String getRandomFacts(Model model) {
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		RandomFact randomFact = restTemplate.getForObject(uri, RandomFact.class);
		
		String textRandomFact = randomFact.getText();
		
		model.addAttribute("textRandomFact", textRandomFact);
		model.addAttribute("pessoas", getPessoas());
		
		return "cards";
	}
	
	private List<Pessoa> getPessoas(){
		return (List<Pessoa>) pessoaRepository.findAll();
	}
}