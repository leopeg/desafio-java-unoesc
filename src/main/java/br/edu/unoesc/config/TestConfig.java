package br.edu.unoesc.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.unoesc.entities.Formacao;
import br.edu.unoesc.entities.Pessoa;
import br.edu.unoesc.entities.Time;
import br.edu.unoesc.repositories.FormacaoRepository;
import br.edu.unoesc.repositories.PessoaRepository;
import br.edu.unoesc.repositories.TimeRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private FormacaoRepository formacaoRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa((long) 1, "Leo", "1200", 0,
										"leopeg1301@gmail.com", "499904", Instant.parse("2024-07-17T02:26:00Z"));
		
		Pessoa p2 = new Pessoa((long) 2, "Gabi", "451122", 1,
				"gabip21silva@gmail.com", "4444399904", Instant.parse("2024-07-27T12:43:00Z"));
		
		Pessoa p3 = new Pessoa((long) 3, "Rafa", "35663423", 2,
				"rafapeg@gmail.com", "5784375", Instant.parse("1990-07-23T12:43:00Z"));
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Formacao f1 = new Formacao((long) 1, "Engenharia da computação", "UNOESC", 3, 
												Instant.parse("2024-07-30T14:03:00Z"));
		
		Formacao f2 = new Formacao((long) 2, "Pedagogia", "UNOESC", 4, 
				Instant.parse("2024-07-30T14:03:00Z"));
		
		Formacao f3 = new Formacao((long) 3, "Ciencia contabeis", "UNOESC", 6, 
				Instant.parse("2024-07-30T14:03:00Z"));
		
		formacaoRepository.saveAll(Arrays.asList(f1, f2, f3));
		
		Time t1 = new Time((long) 1, "Santos", "Futebol");
		Time t2 = new Time((long) 2, "TI", "TI");
		Time t3 = new Time((long) 3, "Papaleguas", "Desenho");
		
		timeRepository.saveAll(Arrays.asList(t1, t2, t3));
		
		p1.setTime(t1);
		p2.setTime(t2);
		p3.setTime(t3);
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2,p3));
	}
}