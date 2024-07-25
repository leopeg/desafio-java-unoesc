package br.edu.unoesc.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import br.edu.unoesc.entities.enums.NivelCurso;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_formacao")
public class Formacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nomeCurso;
	private String instituicao;
	private Integer nivelCurso;
	private Instant dataFormacao;
	
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