package br.edu.unoesc.entities.enums;

public enum Genero {

	MASCULINO(0),
	FEMININO(1),
	OUTROS(2);
	
private Integer code;
	
	private Genero(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static Genero valueOf(Integer code) {
		for (Genero value : Genero.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Genero code");
	}
	
}