package br.edu.unoesc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
import br.edu.unoesc.entities.enums.Genero;
import br.edu.unoesc.records.request.RequestPessoa;
import br.edu.unoesc.records.update.UpdatePessoa;
import br.edu.unoesc.repositories.PessoaRepository;
import br.edu.unoesc.services.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
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
		Pessoa pessoa = new Pessoa(data);
		pessoaRepository.save(pessoa);
		return ResponseEntity.ok("Pessoa cadastrada!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deletePessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
		List<Pessoa> list = pessoaService.findAll();
		pessoaRepository.saveAll(list);
		return ResponseEntity.ok("Pessoa deletada!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updatePessoa(@PathVariable Long id, @RequestBody @Valid UpdatePessoa data) {
		Optional<Pessoa> optionalPessoa = Optional.ofNullable(pessoaService.findById(id));
		Pessoa Pessoa = optionalPessoa.get();
		if(data.nome() != null) {
			Pessoa.setNome(data.nome());
		}
		
		if(data.cpf() != null) {
			Pessoa.setCpf(data.cpf());
		}

		if(data.telefone() != null) {
			Pessoa.setTelefone(data.telefone());
		}
		
		if(data.email() != null) {
			Pessoa.setEmail(data.email());
		}

		if(data.dataNascimento() != null) {
			Pessoa.setDataNascimento(data.dataNascimento());
		}
		
		if(data.genero() != null) {
			Pessoa.setGenero(Genero.valueOf(data.genero()));
		}

		pessoaRepository.save(Pessoa);
		
		return ResponseEntity.ok("Pessoa atualizada!");
		}
	}