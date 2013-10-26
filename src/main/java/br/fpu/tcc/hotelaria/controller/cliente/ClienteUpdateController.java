package br.fpu.tcc.hotelaria.controller.cliente;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class ClienteUpdateController extends ClienteAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private boolean hasNoError = true;

	public boolean isHasNoError() {
		return hasNoError;
	}

	public void loadCliente() {

		if (cliente == null || cliente.getId() == null) {

			try {
				Long idCliente = Long.parseLong(super
						.getQueryStringParam(QueryStringConstants.ID_CLIENTE));
				cliente = clienteBo.findByPrimarykey(idCliente);

				if (cliente == null) {
					throw new BoException("Cliente não encontrado.");
				}

				hasNoError = true;
			} catch (BoException e) {
				super.treatErrorMessage(e,
						BundleConstants.FORMULARIO_EDICAO_ERRO);
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
