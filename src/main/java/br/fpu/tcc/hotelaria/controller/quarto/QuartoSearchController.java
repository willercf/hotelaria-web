package br.fpu.tcc.hotelaria.controller.quarto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class QuartoSearchController extends QuartoAbstractController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<Quarto> quartos = new ArrayList<Quarto>();

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public void search() {

		try {
			quartos = quartoBo.findByFilter(quarto);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public String showUpdate() {

		return "/quartoUpdate?faces-redirect=true&"
				+ QueryStringConstants.ID_QUARTO + "=" + quarto.getId();
	}

}
