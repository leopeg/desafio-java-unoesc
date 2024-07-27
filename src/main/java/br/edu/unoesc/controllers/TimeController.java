package br.edu.unoesc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.entities.Time;
import br.edu.unoesc.records.delete.DeleteTime;
import br.edu.unoesc.records.request.RequestTime;
import br.edu.unoesc.records.update.UpdateTime;
import br.edu.unoesc.repositories.TimeRepository;
import br.edu.unoesc.services.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@GetMapping
	public ResponseEntity<List<Time>> findAll(){
		List<Time> list = timeService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Time> findById(@PathVariable Long id){
		Time obj = timeService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity registerTime(@RequestBody RequestTime data) {
		Time time = new Time(data);
		timeRepository.save(time);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteTime(@PathVariable Long id, @RequestBody DeleteTime data) {
		timeRepository.deleteById(id);
		List<Time> list = timeService.findAll();
		timeRepository.saveAll(list);
		return ResponseEntity.ok("Formação deletada");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updateTime(@PathVariable Long id, @RequestBody UpdateTime data) {
		Optional<Time> optionalTime = timeRepository.findById(id);
		Time Time = optionalTime.get();
		if(data.nome() != null) {
			Time.setNome(data.nome());
		}
		
		if(data.setor() != null) {
			Time.setSetor(data.setor());
		}

		timeRepository.save(Time);
		
		return ResponseEntity.ok().build();
		}
	}