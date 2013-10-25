package br.fpu.tcc.hotelaria.controller.cliente;

import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.TipoPessoa;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ClienteSearchController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ClienteBo clienteBo;

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteBo getClienteBo() {
		return clienteBo;
	}

	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public void search() {

		try {
			clientes = clienteBo.findByFilter(cliente);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FORMULARIO_PESQUISA_ERRO);
		}
	}

	public String showUpdate() {

		return "/clienteUpdate?faces-redirect=true";
	}

}
