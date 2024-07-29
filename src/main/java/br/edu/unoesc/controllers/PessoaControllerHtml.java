package br.edu.unoesc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.repositories.PessoaRepository;

@Controller
public class PessoaControllerHtml {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping("/")
    public String registered(Model model) {
        List<Pessoa> pessoas = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", pessoas);
        return "cards";
    }
}
