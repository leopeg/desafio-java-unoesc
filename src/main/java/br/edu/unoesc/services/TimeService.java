package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Time;
import br.edu.unoesc.repositories.TimeRepository;

@Service
public class TimeService {

	@Autowired
	private TimeRepository timeRepository;
	
	public List<Time> findAll(){
		return (List<Time>) timeRepository.findAll();
	}
	
	public Time findById(Long id) {
		Optional<Time> obj = timeRepository.findById(id);
		return obj.get();
	}
	
}
