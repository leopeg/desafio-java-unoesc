package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return (List<Pessoa>) pessoaRepository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.get();
	}
	
}