package br.fpu.tcc.hotelaria.controller.reserva;

import br.fpu.tcc.hotelaria.enums.StatusReserva;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class ReservaUpdateController extends ReservaAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private boolean hasNoError = true;

	private boolean cancelReserva = false;

	public boolean isHasNoError() {
		return hasNoError;
	}

	public boolean isCancelReserva() {
		return cancelReserva;
	}

	public void setCancelReserva(boolean cancelReserva) {
		this.cancelReserva = cancelReserva;
	}

	public void loadReserva() {

		if (reserva == null || reserva.getId() == null) {
			try {
				Long idReserva = Long.parseLong(super.getQueryStringParam(QueryStringConstants.ID_RESERVA));
				reserva = reservaBo.findByPrimarykey(idReserva);

				if (reserva == null) {
					throw new BoException("Reserva não encontrada.");
				}

				if (!reserva.getStatusReserva().equals(StatusReserva.RESERVED)) {
					throw new BoException("Reserva não pode ser editada.", BundleConstants.RESERVA_EDICAO_ERRO);
				}

				quartos.add(reserva.getQuarto());

				hasNoError = true;
			} catch (BoException e) {
				super.treatErrorMessage(e, BundleConstants.FORMULARIO_EDICAO_ERRO);
				hasNoError = false;
			}
		}
	}

	public String update() {

		try {
			reserva.setFuncionario(super.getAuthenticatedFuncionario());
			if (isCancelReserva()) {
				reserva.setStatusReserva(StatusReserva.CANCELED);
			}
			reservaBo.update(reserva);
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_SUCESSO);
			return "/reservaSearch?faces-redirect=true";
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.RESERVA_CADASTRO_ERRO);
		}

		return null;
	}

}
