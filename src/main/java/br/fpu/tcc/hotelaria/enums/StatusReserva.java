package br.fpu.tcc.hotelaria.enums;

public enum StatusReserva {

	RESERVED("Reservado"), CHECK_IN("Check-In"), CHECK_OUT("Check-Out"), CANCELED("Cancelado");

	private String description;

	private StatusReserva(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static StatusReserva getValue(String name) {

		for (StatusReserva item : values()) {
			if (item.name().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public static StatusReserva getValue(int ordinal) {

		for (StatusReserva item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
