package br.fpu.tcc.hotelaria.controller.reserva;

import java.util.ArrayList;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ReservaCreateController extends ReservaAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String showCreate() {

		reserva = new Reserva();
		quartoFilter = new Quarto();
		quartos = new ArrayList<Quarto>();
		return "/reservaCreate?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			reserva.setFuncionario(super.getAuthenticatedFuncionario());
			id = reservaBo.save(reserva);
			System.out.println("id: " + id);
			reserva = new Reserva();
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_SUCESSO);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.RESERVA_CADASTRO_ERRO);
		}
	}

}
