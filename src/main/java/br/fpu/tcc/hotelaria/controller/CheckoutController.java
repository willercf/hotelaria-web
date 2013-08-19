package br.fpu.tcc.hotelaria.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fpu.tcc.hotelaria.dao.CheckoutDao;
import br.fpu.tcc.hotelaria.dao.CheckoutDaoImp;
import br.fpu.tcc.hotelaria.pojo.Checkout;

@ManagedBean 
@SessionScoped
public class CheckoutController {

	private Checkout checkout;

	@SuppressWarnings("rawtypes")
	private DataModel listaCheckouts;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarCheckouts() {
		List<Checkout> lista = new CheckoutDaoImp().list();
		listaCheckouts = new ListDataModel(lista);
		return listaCheckouts;
	}

	public Checkout getCheckout() {
		return checkout;
	}

	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}

	public void prepararAdicionarCheckout(ActionEvent actionEvent) {
		checkout = new Checkout();
	}

	public void prepararAlterarCheckout(ActionEvent actionEvent) {
		checkout = (Checkout) (listaCheckouts.getRowData());
	}

	public String excluirCheckout() {
		Checkout checkoutTemp = (Checkout) (listaCheckouts.getRowData());
		CheckoutDao dao = new CheckoutDaoImp();
		dao.remove(checkoutTemp);
		return "index";
	}

	public void adicionarCheckout(ActionEvent actionEvent) {
		CheckoutDao dao = new CheckoutDaoImp();
		dao.save(checkout);
	}

	public void alterarCheckout(ActionEvent actionEvent) {
		CheckoutDao dao = new CheckoutDaoImp();
		dao.update(checkout);
	}
}
