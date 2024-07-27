package br.edu.unoesc.records.update;

import java.time.Instant;

import br.edu.unoesc.entities.Time;

public record UpdatePessoa(	String nome,
							String cpf,
							String telefone,
							String email,
							Instant dataNascimento,
							Integer genero,
							Time time) {}