package br.edu.unoesc.entities;

public class PessoaComFatoAleatorio {

	 private String nome;
	 private String randomFact;
	 
	 public PessoaComFatoAleatorio() {}

	public PessoaComFatoAleatorio(String nome, String randomFact) {
		super();
		this.nome = nome;
		this.randomFact = randomFact;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRandomFact() {
		return randomFact;
	}

	public void setRandomFact(String randomFact) {
		this.randomFact = randomFact;
	}
	
}