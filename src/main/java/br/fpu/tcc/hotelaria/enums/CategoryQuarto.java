package br.fpu.tcc.hotelaria.enums;

public enum CategoryQuarto {

	LUXURY("Luxo"), STANDARD("Padrão"), SIMPLE("Simples");

	private String description;

	private CategoryQuarto(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static CategoryQuarto getValue(String name) {

		for (CategoryQuarto item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public static CategoryQuarto getValue(int ordinal) {

		for (CategoryQuarto item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
