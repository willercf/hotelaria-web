package br.fpu.tcc.hotelaria.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fpu.tcc.hotelaria.dao.CheckinDao;
import br.fpu.tcc.hotelaria.dao.CheckinDaoImp;
import br.fpu.tcc.hotelaria.pojo.Checkin;

@ManagedBean 
@SessionScoped
public class CheckinController {

	private Checkin checkin;

	@SuppressWarnings("rawtypes")
	private DataModel listaCheckins;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarCheckins() {
		List<Checkin> lista = new CheckinDaoImp().list();
		listaCheckins = new ListDataModel(lista);
		return listaCheckins;
	}

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

	public void prepararAdicionarCheckin(ActionEvent actionEvent) {
		checkin = new Checkin();
	}

	public void prepararAlterarCheckin(ActionEvent actionEvent) {
		checkin = (Checkin) (listaCheckins.getRowData());
	}

	public String excluirCheckin() {
		Checkin checkinTemp = (Checkin) (listaCheckins.getRowData());
		CheckinDao dao = new CheckinDaoImp();
		dao.remove(checkinTemp);
		return "index";
	}

	public void adicionarCheckin(ActionEvent actionEvent) {
		CheckinDao dao = new CheckinDaoImp();
		dao.save(checkin);
	}

	public void alterarCheckin(ActionEvent actionEvent) {
		CheckinDao dao = new CheckinDaoImp();
		dao.update(checkin);
	}
}
