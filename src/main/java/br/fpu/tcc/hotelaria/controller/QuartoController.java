package br.fpu.tcc.hotelaria.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fpu.tcc.hotelaria.dao.QuartoDao;
import br.fpu.tcc.hotelaria.dao.QuartoDaoImp;
import br.fpu.tcc.hotelaria.pojo.Quarto;

@ManagedBean 
@SessionScoped
public class QuartoController {

	private Quarto quarto;

	@SuppressWarnings("rawtypes")
	private DataModel listaQuartos;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaQuartos() {
		List<Quarto> lista = new QuartoDaoImp().list();
		listaQuartos = new ListDataModel(lista);
		return listaQuartos;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public void prepararAdicionarQuarto(ActionEvent actionEvent) {
		quarto = new Quarto();
	}

	public void prepararAlterarQuarto(ActionEvent actionEvent) {
		quarto = (Quarto) (listaQuartos.getRowData());
	}

	public String excluirQuarto() {
		Quarto quartoTemp = (Quarto) (listaQuartos.getRowData());
		QuartoDao dao = new QuartoDaoImp();
		dao.remove(quartoTemp);
		return "index";
	}

	public void adicionarQuarto(ActionEvent actionEvent) {
		QuartoDao dao = new QuartoDaoImp();
		dao.save(quarto);
	}

	public void alterarQuarto(ActionEvent actionEvent) {
		QuartoDao dao = new QuartoDaoImp();
		dao.update(quarto);
	}
}
