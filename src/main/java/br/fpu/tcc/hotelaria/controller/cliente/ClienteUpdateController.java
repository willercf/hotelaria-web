package br.fpu.tcc.hotelaria.controller.cliente;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.TipoPessoa;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class ClienteUpdateController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ClienteBo clienteBo;

	private Cliente cliente = new Cliente();

	private boolean hasNoError = true;

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

	public boolean isHasNoError() {
		return hasNoError;
	}

	public void loadCliente() {

		if (cliente == null || cliente.getId() == null) {

			try {
				Long idCliente = Long.parseLong(super.getQueryStringParam(QueryStringConstants.ID_CLIENTE));
				cliente = clienteBo.findByPrimarykey(idCliente);

				if (cliente == null) {
					throw new BoException("Cliente não encontrado.");
				}

				hasNoError = true;
			} catch (BoException e) {
				super.treatErrorMessage(e, BundleConstants.FORMULARIO_EDICAO_ERRO);
				hasNoError = false;
			}
		}
	}

	public String update() {

		try {
			clienteBo.update(cliente);
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_SUCESSO);
			return "/clienteSearch?faces-redirect=true";
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.CLIENTE_CADASTRO_ERRO);
		}

		return null;
	}
}
