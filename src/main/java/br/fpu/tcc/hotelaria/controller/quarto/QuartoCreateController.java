package br.fpu.tcc.hotelaria.controller.quarto;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class QuartoCreateController extends QuartoAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String showCreate() {

		quarto = new Quarto();
		return "/quartoCreate?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = quartoBo.save(quarto);
			System.out.println("id: " + id);
			quarto = new Quarto();
			super.addGlobalMessage(BundleConstants.QUARTO_CADASTRO_SUCESSO);
		} catch (BoException e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.QUARTO_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}

}
