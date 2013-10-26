package br.fpu.tcc.hotelaria.controller.quarto;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class QuartoUpdateController extends QuartoAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private boolean hasNoError = true;

	public boolean isHasNoError() {
		return hasNoError;
	}

	public void loadQuarto() {

		if (quarto == null || quarto.getId() == null) {

			try {
				Long idQuarto = Long.parseLong(super
						.getQueryStringParam(QueryStringConstants.ID_QUARTO));
				quarto = quartoBo.findByPrimarykey(idQuarto);

				if (quarto == null) {
					throw new BoException("Quarto não encontrado.");
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
			quartoBo.update(quarto);
			super.addGlobalMessage(BundleConstants.QUARTO_CADASTRO_SUCESSO);
			return "/quartoSearch?faces-redirect=true";
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.QUARTO_CADASTRO_ERRO);
		}

		return null;
	}
}
