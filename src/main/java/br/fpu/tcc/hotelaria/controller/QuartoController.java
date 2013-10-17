package br.fpu.tcc.hotelaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.enums.CategoriaQuarto;
import br.fpu.tcc.hotelaria.model.bo.QuartoBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class QuartoController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private QuartoBo quartoBo;

	private Quarto quarto = new Quarto();

	private List<Quarto> quartos = new ArrayList<Quarto>();

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

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public CategoriaQuarto[] getCategorias() {
		return CategoriaQuarto.values();
	}

	public String showInsert() {

		quarto = new Quarto();
		quartos = new ArrayList<Quarto>();
		return "/quartoInsert?faces-redirect=true";
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

		return "/quartoEdit?faces-redirect=true";
	}

	public String update() {

		try {
			quartoBo.update(quarto);
			super.addGlobalMessage(BundleConstants.QUARTO_CADASTRO_SUCESSO);
			return "/quartoList?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.QUARTO_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}

		return null;
	}
}
