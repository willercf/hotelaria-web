package br.fpu.tcc.hotelaria.controller.quarto;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.enums.CategoriaQuarto;
import br.fpu.tcc.hotelaria.model.bo.QuartoBo;
import br.fpu.tcc.hotelaria.pojo.Quarto;

public class QuartoAbstractController extends BaseController {

	/**
	 *
	 */
	protected static final long serialVersionUID = 1L;

	protected QuartoBo quartoBo;

	protected Quarto quarto = new Quarto();

	public QuartoBo getQuartoBo() {
		return quartoBo;
	}

	public void setQuartoBo(QuartoBo quartoBo) {
		this.quartoBo = quartoBo;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public CategoriaQuarto[] getCategorias() {
		return CategoriaQuarto.values();
	}
}
