package br.fpu.tcc.hotelaria.controller.reserva;

import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class CheckInController extends ReservaAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private List<Reserva> reservas = new ArrayList<Reserva>();

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void search() {

		try {
			reservas = reservaBo.findForCheckIn(reserva);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FORMULARIO_PESQUISA_ERRO);
		}
	}

	public String showUpdate() {

		return "/reservaUpdate?faces-redirect=true&" + QueryStringConstants.ID_RESERVA + "=" + reserva.getId();
	}

	public void registerCheckIn() {

		try {
			reservaBo.registerCheckIn(reserva);
			super.addGlobalMessage(BundleConstants.CHECK_IN_CADASTRO_SUCESSO);
			search();
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.CHECK_IN_CADASTRO_ERRO);
		}
	}

}
