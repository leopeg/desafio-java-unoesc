package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Formacao;
import br.edu.unoesc.entities.enums.NivelCurso;
import br.edu.unoesc.records.request.RequestFormacao;
import br.edu.unoesc.records.update.UpdateFormacao;
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
	
	public void registerFormacao(RequestFormacao data) {
		Formacao formacao = new Formacao(data);
		formacaoRepository.save(formacao);
	}
	
	public void deleteFormacao(Long id) {
		formacaoRepository.deleteById(id);
		List<Formacao> list = findAll();
		formacaoRepository.saveAll(list);
	}
	
	public void updateFormacao(UpdateFormacao data, Long id) {
		Optional<Formacao> optionalFormacao = Optional.ofNullable(findById(id));
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
	}
}