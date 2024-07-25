package br.edu.unoesc.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_time")
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;
	private String setor;
	
}