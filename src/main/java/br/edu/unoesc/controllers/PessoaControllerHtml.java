package br.edu.unoesc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.services.PessoaService;

@Controller
public class PessoaControllerHtml {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/")
    public String registered(Model model) {
        List<Pessoa> pessoas = (List<Pessoa>) pessoaService.findAll();
        model.addAttribute("pessoas", pessoas);
        return "cards";
    }
}