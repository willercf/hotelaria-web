package br.fpu.tcc.hotelaria.enums;

public enum CategoriaQuarto {

	LUXURY("Luxo"), STANDARD("Padrão"), SIMPLE("Simples");

	private String description;

	private CategoriaQuarto(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static CategoriaQuarto getValue(String name) {

		for (CategoriaQuarto item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public static CategoriaQuarto getValue(int ordinal) {

		for (CategoriaQuarto item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
