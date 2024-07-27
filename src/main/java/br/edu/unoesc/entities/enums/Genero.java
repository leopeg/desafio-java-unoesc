package br.edu.unoesc.entities.enums;

public enum Genero {

	MASCULINO(0),
	FEMININO(1),
	OUTROS(2);
	
private int code;
	
	private Genero(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Genero valueOf(int code) {
		for (Genero value : Genero.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Genero code");
	}
	
}