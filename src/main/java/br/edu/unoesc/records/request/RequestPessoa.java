package br.edu.unoesc.records.request;

import java.time.Instant;

import br.edu.unoesc.entities.Time;

public record RequestPessoa(Long id,
							String nome,
							String cpf,
							String telefone,
							String email,
							Instant dataNascimento,
							Integer genero,
							Time time) {}