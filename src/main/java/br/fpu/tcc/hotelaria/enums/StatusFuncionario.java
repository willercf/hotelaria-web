package br.fpu.tcc.hotelaria.enums;

public enum StatusFuncionario {

	ACTIVE("Ativo"), INACTIVE("Inativo");

	private String description;

	private StatusFuncionario(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static StatusFuncionario getValue(String name) {

		for (StatusFuncionario item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public static StatusFuncionario getValue(int ordinal) {

		for (StatusFuncionario item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
