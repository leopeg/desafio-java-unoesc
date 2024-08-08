---------------------PessoaController---------------------

Metodo GET:

	- Retorno de todos os registros:
		http://localhost:8080/pessoas
		
	- Retorno de um registro especifico:
		http://localhost:8080/pessoas/id
		
Metodo POST:

	- JSON para criar novo registro:
		{
		"id":var Long
	        "nome": var String,
	        "cpf": var String | CPF Válido,
	        "telefone": var String,
	        "email": var String | E-mail com formatação válida,
	        "dataNascimento": var String no formato ISO 8601,
	        "genero": var Long
		}
		
Metodo PUT:

	- É necessário acessar um registro especifíco e passar um Body em JSON:
			- Retorno de um registro especifico:
				http://localhost:8080/pessoas/id
				
				- JSON para atualizar registro (Nenhuma váriavel é obrigatória):
					{
				        "nome": var String,
				        "cpf": var String | CPF Válido,
				        "telefone": var String,
				        "email": var String | E-mail com formatação válida,
				        "dataNascimento": var String no formato ISO 8601,
				        "genero": var Long
					}
					
Metodo DELETE:
	
	- É necessário deletar um registro específico através do ID:
		http://localhost:8080/pessoas/id
		
---------------------FormacaoController---------------------

Metodo GET:

	- Retorno de todos os registros:
		http://localhost:8080/formacoes
		
	- Retorno de um registro especifico:
		http://localhost:8080/formacoes/id
		
Metodo POST:

	- JSON para criar novo registro:
		{
		"id":var Long
	        "nomeCurso": var String,
	        "instituicao": var String,
	        "nivelCurso": var Long,
	        "dataFormacao": var String no formato ISO 8601
		}
		
Metodo PUT:

	- É necessário acessar um registro especifíco e passar um Body em JSON:
			- Retorno de um registro especifico:
				http://localhost:8080/formacoes/id
				
				- JSON para atualizar registro (Nenhuma váriavel é obrigatória):
					{
				        "nomeCurso": var String,
				        "instituicao": var String,
				        "nivelCurso": var Long,
				        "dataFormacao": var String no formato ISO 8601
					}
					
Metodo DELETE:
	
	- É necessário deletar um registro específico através do ID:
		http://localhost:8080/formacoes/id
		
---------------------TimeController---------------------

Metodo GET:

	- Retorno de todos os registros:
		http://localhost:8080/times
		
	- Retorno de um registro especifico:
		http://localhost:8080/times/id
		
Metodo POST:

	- JSON para criar novo registro:
		{
		"id":var Long
	        "nome": var String,
	        "setor": var String,
		}
		
Metodo PUT:

	- É necessário acessar um registro especifíco e passar um Body em JSON:
			- Retorno de um registro especifico:
				http://localhost:8080/times/id
				
				- JSON para atualizar registro (Nenhuma váriavel é obrigatória):
					{
				        "nome": var String,
				        "setor": var String,
					}
					
Metodo DELETE:
	
	- É necessário deletar um registro específico através do ID:
		http://localhost:8080/times/id
		
--------------------------------------------------------------------------------------------------------