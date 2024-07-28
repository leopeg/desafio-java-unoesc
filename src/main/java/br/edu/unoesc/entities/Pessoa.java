package br.edu.unoesc.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import br.edu.unoesc.annotations.CpfValidator;
import br.edu.unoesc.entities.enums.Genero;
import br.edu.unoesc.records.request.RequestPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	@CpfValidator
	private String cpf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dataNascimento")
	private Instant dataNascimento;
	
	@Column(name="genero")
	private Integer genero;
	
	@JoinColumn(name="id")
	private Time time;
	
	public Pessoa() {}

	public Pessoa(Long id, String nome, String cpf, Integer genero, 
					String telefone, String email, Instant dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public Pessoa(RequestPessoa data) {
		this.id = data.id();
		this.nome = data.nome();
		this.cpf = data.cpf();
		this.genero = data.genero();
		this.telefone = data.telefone();
		this.email = data.email();
		this.dataNascimento = data.dataNascimento();
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

	public Genero getGenero() {
		return Genero.valueOf(genero);
	}

	public void setGenero(Genero genero) {
		if(genero != null){
			this.genero = genero.getCode();
		}
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
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
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