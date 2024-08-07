package br.edu.unoesc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.entities.Formacao;
import br.edu.unoesc.records.request.RequestFormacao;
import br.edu.unoesc.records.update.UpdateFormacao;
import br.edu.unoesc.services.FormacaoService;

@RestController
@RequestMapping(value = "/formacoes")
public class FormacaoController {

	@Autowired
	private FormacaoService formacaoService;
	
	@GetMapping
	public ResponseEntity<List<Formacao>> findAll(){
		List<Formacao> list = formacaoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Formacao> findById(@PathVariable Long id){
		Formacao obj = formacaoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity registerFormacao(@RequestBody RequestFormacao data) {
		formacaoService.registerFormacao(data);
		return ResponseEntity.ok("Formação cadastrada!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteFormacao(@PathVariable Long id) {
		formacaoService.deleteFormacao(id);
		return ResponseEntity.ok("Formação deletada!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updateFormacao(@PathVariable Long id, @RequestBody UpdateFormacao data) {
		formacaoService.updateFormacao(data, id);
		return ResponseEntity.ok("Formação atualiazada!");
		}
	}