package br.fpu.tcc.hotelaria.controller.cliente;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.TipoPessoa;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ClienteCreateController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ClienteBo clienteBo;

	private Cliente cliente = new Cliente();

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

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public String showCreate() {

		cliente = new Cliente();
		return "/clienteCreate?faces-redirect=true";
	}

	public boolean disableMask() {

		return cliente.getTipoPessoa() == null;
	}

	public String getMask() {

		if (TipoPessoa.F.equals(cliente.getTipoPessoa())) {
			return "999.999.999-99";
		}

		if (TipoPessoa.J.equals(cliente.getTipoPessoa())) {
			return "99.999.999/9999-99";
		}

		return "";
	}

	public void save() {
		Long id;
		try {
			id = clienteBo.save(cliente);
			System.out.println("id: " + id);
			cliente = new Cliente();
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_SUCESSO);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.CLIENTE_CADASTRO_ERRO);
		}
	}

}
