package br.edu.unoesc.records.update;

import java.time.Instant;

import br.edu.unoesc.entities.Pessoa;

public record UpdateFormacao(String nomeCurso,
							 String instituicao,
							 Integer nivelCurso,
							 Instant dataFormacao,
							 Pessoa pessoa) {}