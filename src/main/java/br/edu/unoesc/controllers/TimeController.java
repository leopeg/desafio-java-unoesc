package br.edu.unoesc.controllers;

import java.util.List;

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
import br.edu.unoesc.records.request.RequestTime;
import br.edu.unoesc.records.update.UpdateTime;
import br.edu.unoesc.services.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeController {

	@Autowired
	private TimeService timeService;
	
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
		timeService.registerTime(data);
		return ResponseEntity.ok("Time cadastrado!");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteTime(@PathVariable Long id) {
		timeService.deleteTime(id);
		return ResponseEntity.ok("Time deletado");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity updateTime(@PathVariable Long id, @RequestBody UpdateTime data) {
		timeService.updateTime(data, id);
		return ResponseEntity.ok("Time atualizado!");
		}
	
}