package br.edu.unoesc.controllers;

import java.util.List;
import java.util.Optional;

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
import br.edu.unoesc.entities.enums.NivelCurso;
import br.edu.unoesc.records.delete.DeleteFormacao;
import br.edu.unoesc.records.request.RequestFormacao;
import br.edu.unoesc.records.update.UpdateFormacao;
import br.edu.unoesc.repositories.FormacaoRepository;
import br.edu.unoesc.services.FormacaoService;

@RestController
@RequestMapping(value = "/formacoes")
public class FormacaoController {

	@Autowired
	private FormacaoService formacaoService;
	
	@Autowired
	private FormacaoRepository formacaoRepository;
	
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
		Formacao formacao = new Formacao(data);
		formacaoRepository.save(formacao);
		return ResponseEntity.ok("Formação cadastrada!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteFormacao(@PathVariable Long id) {
		formacaoRepository.deleteById(id);
		List<Formacao> list = formacaoService.findAll();
		formacaoRepository.saveAll(list);
		return ResponseEntity.ok("Formação deletada!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updateFormacao(@PathVariable Long id, @RequestBody UpdateFormacao data) {
		Optional<Formacao> optionalFormacao = formacaoRepository.findById(id);
		Formacao Formacao = optionalFormacao.get();
		if(data.nomeCurso() != null) {
			Formacao.setNomeCurso(data.nomeCurso());
		}
		
		if(data.instituicao() != null) {
			Formacao.setInstituicao(data.instituicao());
		}

		if(data.nivelCurso() != null) {
			Formacao.setNivelCurso(NivelCurso.valueOf(data.nivelCurso()));
		}
		
		if(data.dataFormacao() != null) {
			Formacao.setDataFormacao(data.dataFormacao());
		}

		formacaoRepository.save(Formacao);
		
		return ResponseEntity.ok("Formação atualiazada!");
		}
	}