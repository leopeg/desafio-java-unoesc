package br.edu.unoesc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.edu.unoesc.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}