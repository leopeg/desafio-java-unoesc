package br.edu.unoesc.entities.enums;

public enum NivelCurso {

	ENSINO_MEDIO(0),
	TÉCNICO(1),
	BACHARELADO(2),
	ESPECIALIZAÇÃO(3),
	MESTRADO(4),
	DOUTORADO(5),
	OUTROS(6);
	
private int code;
	
	private NivelCurso(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static NivelCurso valueOf(int code) {
		for (NivelCurso value : NivelCurso.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid NivelCurso code");
	}
}