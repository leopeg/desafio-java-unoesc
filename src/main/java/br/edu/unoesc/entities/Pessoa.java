package br.edu.unoesc.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Instant dataNascimento;
	
	private List<String> genero = new ArrayList<String>(Arrays.asList
															("Masculino", "Feminino", "Outros"));
	
	private Time time;
	
	public Pessoa() {}

	public Pessoa(Long id, String nome, String cpf, List<String> genero, String telefone, String email, Instant dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getGenero() {
		return genero;
	}

	public void setGenero(List<String> genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
}