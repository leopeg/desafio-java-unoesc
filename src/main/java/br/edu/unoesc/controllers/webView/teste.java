package br.edu.unoesc.controllers.webView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.entities.Pessoa;

@Controller
public class teste {

	@GetMapping(value = "/cards")
	public String home() {
		return "cards";
	}
	
	@ModelAttribute(value = "pessoa")
	@PostMapping(value = "/cadastrarPessoa")
	public void cadastroPessoa(Pessoa pessoa) {
		System.out.println("O nome da pessoa é: " + pessoa.getNome());
	}
}