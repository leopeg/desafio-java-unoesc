package br.edu.unoesc.controllers.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.entities.PessoaComFatoAleatorio;
import br.edu.unoesc.services.ApiService;
import br.edu.unoesc.services.PessoaService;

@Controller
public class RandomFacts {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/randomFacts")
	public String getTextRandomFact(Model model) {
		List<Pessoa> pessoas = getPessoas();
		List<PessoaComFatoAleatorio> pComFato = new ArrayList();
		
		for(Pessoa pessoa : pessoas) {
			String textRandomFact = apiService.getRandomFacts();
			pComFato.add(new PessoaComFatoAleatorio(pessoa.getNome(), textRandomFact));
		}
		
		model.addAttribute("pessoasComFatoAleatorio", pComFato);
		
		return "cards";
	}
	
	private List<Pessoa> getPessoas(){
		return (List<Pessoa>) pessoaService.findAll();
	}
}