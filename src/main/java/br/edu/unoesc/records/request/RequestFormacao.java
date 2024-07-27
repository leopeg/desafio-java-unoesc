package br.edu.unoesc.records.request;

import java.time.Instant;

import br.edu.unoesc.entities.Pessoa;

public record RequestFormacao(Long id,
							  String nomeCurso,
							  String instituicao,
							  Integer nivelCurso,
							  Instant dataFormacao,
							  Pessoa pessoa) {}