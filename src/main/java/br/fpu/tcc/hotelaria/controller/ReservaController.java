package br.fpu.tcc.hotelaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.enums.CategoriaQuarto;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.QuartoBo;
import br.fpu.tcc.hotelaria.model.bo.ReservaBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ReservaController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ReservaBo reservaBo;

	private ClienteBo clienteBo;

	private QuartoBo quartoBo;

	private Reserva reserva = new Reserva();

	private List<Reserva> reservas = new ArrayList<Reserva>();

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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public CategoriaQuarto[] getCategorias() {
		return CategoriaQuarto.values();
	}

	public String showInsert() {

		reserva = new Reserva();
		reservas = new ArrayList<Reserva>();
		return "/reservaInsert?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = reservaBo.save(reserva);
			System.out.println("id: " + id);
			reserva = new Reserva();
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_SUCESSO);
		} catch (BoException e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public void search() {

		try {
			reservas = reservaBo.findByFilter(reserva);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public String showUpdate() {

		return "/reservaEdit?faces-redirect=true";
	}

	public String update() {

		try {
			reservaBo.update(reserva);
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_SUCESSO);
			return "/reservaList?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.RESERVA_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}

		return null;
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

	private Funcionario getAuthenticatedFuncionario() {

		// TODO Refatorar para obter funcionário da sessão
		return new Funcionario(1L);
	}
}
