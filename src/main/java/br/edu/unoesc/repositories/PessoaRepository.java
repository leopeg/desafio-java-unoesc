package br.edu.unoesc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.entities.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}