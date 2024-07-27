package br.edu.unoesc.entities;

import java.io.Serializable;
import java.util.Objects;

import br.edu.unoesc.records.request.RequestTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_time")
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="setor")
	private String setor;
	
	public Time() {}

	public Time(Long id, String nome, String setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.setor = setor;
	}
	
	public Time(RequestTime data) {
		this.id = data.id();
		this.nome = data.nome();
		this.setor = data.setor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
}