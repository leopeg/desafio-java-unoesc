package br.edu.unoesc.controllers.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.entities.PessoaComFatoAleatorio;
import br.edu.unoesc.entities.RandomFact;
import br.edu.unoesc.repositories.PessoaRepository;

@Controller
public class RandomFacts {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping("/randomFacts")
	public String getTextRandomFact(Model model) {
		List<Pessoa> pessoas = getPessoas();
		List<PessoaComFatoAleatorio> pComFato = new ArrayList();
		
		for(Pessoa pessoa : pessoas) {
			String textRandomFact = getRandomFacts();
			pComFato.add(new PessoaComFatoAleatorio(pessoa.getNome(), textRandomFact));
		}
		
		model.addAttribute("pessoasComFatoAleatorio", pComFato);
		
		return "cards";
	}
	
	public String getRandomFacts() {
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		RandomFact randomFact = restTemplate.getForObject(uri, RandomFact.class);
		
		return (randomFact != null) ? randomFact.getText() : "Nenhum fato aleatório!";
	}
	
	private List<Pessoa> getPessoas(){
		return (List<Pessoa>) pessoaRepository.findAll();
	}
}