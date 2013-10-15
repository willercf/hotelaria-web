package br.fpu.tcc.hotelaria.pojo;

public enum StatusFuncionario {

	ACTIVE("Ativo"), INACTIVE("Inativo");

	private String description;

	private StatusFuncionario(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static StatusFuncionario getValue(String description) {

		for (StatusFuncionario item : values()) {
			if (item.getDescription().equals(description)) {
				return item;
			}
		}
		return null;
	}
}
