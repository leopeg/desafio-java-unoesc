package br.edu.unoesc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.edu.unoesc.entities.Time;

public interface TimeRepository extends CrudRepository<Time, Long>{

}