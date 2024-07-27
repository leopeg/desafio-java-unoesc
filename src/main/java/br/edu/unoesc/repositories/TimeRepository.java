package br.edu.unoesc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.entities.Time;

@Repository
public interface TimeRepository extends CrudRepository<Time, Long>{

}