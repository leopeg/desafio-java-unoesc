package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.entities.enums.Genero;
import br.edu.unoesc.records.request.RequestPessoa;
import br.edu.unoesc.records.update.UpdatePessoa;
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
	
	public void registerPessoa(RequestPessoa data){
		Pessoa pessoa = new Pessoa(data);
		pessoaRepository.save(pessoa);
	}
	
	public void deletePessoa(Long id) {
		pessoaRepository.deleteById(id);
		List <Pessoa> list = findAll();
		pessoaRepository.saveAll(list);
	}
	
	public void updatePessoa(UpdatePessoa data, Long id) {
		Optional<Pessoa> optionalPessoa = Optional.ofNullable(findById(id));
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
	}
	
}