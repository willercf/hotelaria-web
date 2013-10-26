package br.fpu.tcc.hotelaria.controller.cliente;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.TipoPessoa;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ClienteAbstractController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected ClienteBo clienteBo;

	protected Cliente cliente = new Cliente();

	protected String cpfCnpjMask = "";

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

	public String getCpfCnpjMask() {
		return cpfCnpjMask;
	}

	public void changeMask() {

		if (TipoPessoa.F.equals(cliente.getTipoPessoa())) {
			cpfCnpjMask = getBundle().getString(
					BundleConstants.FORMULARIO_MASK_CPF);
			return;
		}

		if (TipoPessoa.J.equals(cliente.getTipoPessoa())) {
			cpfCnpjMask = getBundle().getString(
					BundleConstants.FORMULARIO_MASK_CNPJ);
			return;
		}

		cpfCnpjMask = "";
	}
}
