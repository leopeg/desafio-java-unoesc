package br.edu.unoesc.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import br.edu.unoesc.entities.enums.NivelCurso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_formacao")
public class Formacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="nomeCurso")
	private String nomeCurso;
	
	@Column(name="instuticao")
	private String instituicao;
	
	@Column(name="nivelCurso")
	private Integer nivelCurso;
	
	@Column(name="dataFormacao")
	private Instant dataFormacao;
	
	@JoinColumn(name="id")
	private Pessoa pessoa;
	
	public Formacao() {}

	public Formacao(Long id, String nomeCurso, String instituicao, Integer nivelCurso, Instant dataFormacao) {
		super();
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.instituicao = instituicao;
		this.nivelCurso = nivelCurso;
		this.dataFormacao = dataFormacao;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public NivelCurso getNivelCurso() {
		return NivelCurso.valueOf(nivelCurso);
	}

	public void setNivelCurso(NivelCurso nivelCurso) {
		if(nivelCurso != null){
			this.nivelCurso = nivelCurso.getCode();
		}
	}

	public Instant getDataFormacao() {
		return dataFormacao;
	}

	public void setDataFormacao(Instant dataFormacao) {
		this.dataFormacao = dataFormacao;
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
		Formacao other = (Formacao) obj;
		return Objects.equals(id, other.id);
	}
}