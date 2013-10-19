package br.fpu.tcc.hotelaria.enums;

public enum TipoPessoa {

	F("Física"), J("Juridica");

	private String description;

	private TipoPessoa(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static TipoPessoa getValue(String name) {

		for (TipoPessoa item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}
}
