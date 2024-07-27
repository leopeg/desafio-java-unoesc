package br.edu.unoesc.controllers.webView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class teste {

	@GetMapping(value = "/randomFactsPeople")
	public String randomFactsPeople() {
		return "randomFactsPeople";
	}
	
}