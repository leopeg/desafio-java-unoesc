package br.edu.unoesc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.records.request.RequestPessoa;
import br.edu.unoesc.records.update.UpdatePessoa;
import br.edu.unoesc.services.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ModelAttribute("pessoas")
	public List<Pessoa> pessoas() {
		return (List<Pessoa>) pessoaService.findAll();
	}
	
	@PostMapping
	public ResponseEntity registerPessoa(@RequestBody @Valid RequestPessoa data) {
		pessoaService.registerPessoa(data);
		return ResponseEntity.ok("Pessoa cadastrada!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deletePessoa(@PathVariable Long id) {
		pessoaService.deletePessoa(id);
		return ResponseEntity.ok("Pessoa deletada!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updatePessoa(@PathVariable Long id, @RequestBody @Valid UpdatePessoa data) {
		pessoaService.updatePessoa(data, id);
		return ResponseEntity.ok("Pessoa atualizada!");
		}
	}