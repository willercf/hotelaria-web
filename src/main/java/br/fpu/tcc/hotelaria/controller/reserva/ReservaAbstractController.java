package br.fpu.tcc.hotelaria.controller.reserva;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.CategoriaQuarto;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.QuartoBo;
import br.fpu.tcc.hotelaria.model.bo.ReservaBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ReservaAbstractController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected ReservaBo reservaBo;

	protected ClienteBo clienteBo;

	protected QuartoBo quartoBo;

	protected Reserva reserva = new Reserva();

	protected Quarto quartoFilter = new Quarto();

	protected List<Quarto> quartos = new ArrayList<Quarto>();

	public ReservaBo getReservaBo() {
		return reservaBo;
	}

	public void setReservaBo(ReservaBo reservaBo) {
		this.reservaBo = reservaBo;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public ClienteBo getClienteBo() {
		return clienteBo;
	}

	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	public QuartoBo getQuartoBo() {
		return quartoBo;
	}

	public void setQuartoBo(QuartoBo quartoBo) {
		this.quartoBo = quartoBo;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Quarto getQuartoFilter() {
		return quartoFilter;
	}

	public void setQuartoFilter(Quarto quartoFilter) {
		this.quartoFilter = quartoFilter;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public CategoriaQuarto[] getCategorias() {
		return CategoriaQuarto.values();
	}

	public List<Cliente> findClienteByName(String query) {

		Cliente filter = new Cliente(query);
		List<Cliente> result = null;

		try {
			result = clienteBo.findByFilter(filter);
		} catch (BoException e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}

		return result;
	}

	public void searchQuartos() {

		try {
			quartos = quartoBo.findByFilter(quartoFilter);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}
}
