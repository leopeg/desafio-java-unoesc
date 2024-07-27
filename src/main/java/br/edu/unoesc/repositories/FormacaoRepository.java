package br.edu.unoesc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.entities.Formacao;

@Repository
public interface FormacaoRepository extends CrudRepository<Formacao, Long>{

}