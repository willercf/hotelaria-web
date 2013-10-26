package br.fpu.tcc.hotelaria.controller.cliente;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ClienteCreateController extends ClienteAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String showCreate() {

		cliente = new Cliente();
		return "/clienteCreate?faces-redirect=true";
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
