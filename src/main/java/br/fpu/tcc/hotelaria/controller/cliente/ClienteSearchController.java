package br.fpu.tcc.hotelaria.controller.cliente;

import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class ClienteSearchController extends ClienteAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void search() {

		try {
			clientes = clienteBo.findByFilter(cliente);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FORMULARIO_PESQUISA_ERRO);
		}
	}

	public String showUpdate() {

		return "/clienteUpdate?faces-redirect=true&"
				+ QueryStringConstants.ID_CLIENTE + "=" + cliente.getId();
	}
}
