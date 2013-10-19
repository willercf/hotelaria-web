package br.fpu.tcc.hotelaria.enums;

public enum StatusQuarto {

	AVAILABLE("Disponivel"), RESERVED("Reservado"), OCCUPIED("Ocupado");

	private String description;

	private StatusQuarto(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static StatusQuarto getValue(String name) {

		for (StatusQuarto item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public static StatusQuarto getValue(int ordinal) {

		for (StatusQuarto item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
