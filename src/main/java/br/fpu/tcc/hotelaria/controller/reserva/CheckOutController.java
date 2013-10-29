package br.fpu.tcc.hotelaria.controller.reserva;

import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class CheckOutController extends ReservaAbstractController {

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
			reservas = reservaBo.findForCheckOut(reserva);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FORMULARIO_PESQUISA_ERRO);
		}
	}

	public void registerCheckOut() {

		try {
			reservaBo.registerCheckOut(reserva);
			super.addGlobalMessage(BundleConstants.CHECK_OUT_CADASTRO_SUCESSO);
			search();
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.CHECK_OUT_CADASTRO_ERRO);
		}
	}

}
