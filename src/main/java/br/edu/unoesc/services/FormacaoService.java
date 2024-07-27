package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Formacao;
import br.edu.unoesc.repositories.FormacaoRepository;

@Service
public class FormacaoService {

	@Autowired
	private FormacaoRepository formacaoRepository;
	
	public List<Formacao> findAll(){
		return (List<Formacao>) formacaoRepository.findAll();
	}
	
	public Formacao findById(Long id) {
		Optional<Formacao> obj = formacaoRepository.findById(id);
		return obj.get();
	}
	
}