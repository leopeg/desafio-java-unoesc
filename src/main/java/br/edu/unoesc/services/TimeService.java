package br.edu.unoesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.entities.Time;
import br.edu.unoesc.records.request.RequestTime;
import br.edu.unoesc.records.update.UpdateTime;
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
	
	public void registerTime(RequestTime data) {
		Time time = new Time(data);
		timeRepository.save(time);
	}
	
	public void deleteTime(Long id) {
		timeRepository.deleteById(id);
		List<Time> list = findAll();
		timeRepository.saveAll(list);
	}
	
	public void updateTime(UpdateTime data, Long id) {
		Optional<Time> optionalTime = Optional.ofNullable(findById(id));
		Time Time = optionalTime.get();
		if(data.nome() != null) {
			Time.setNome(data.nome());
		}
		
		if(data.setor() != null) {
			Time.setSetor(data.setor());
		}

		timeRepository.save(Time);
	}
}
