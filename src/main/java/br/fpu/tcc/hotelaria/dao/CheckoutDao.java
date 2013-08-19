package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Checkout;

public interface CheckoutDao {

	public void save(Checkout checkout);

	public Checkout getCheckout(long idCheckout);

	public List<Checkout> list();

	public void remove(Checkout checkout);

	public void update(Checkout checkout);
}
