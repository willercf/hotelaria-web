package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Checkout;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class CheckoutDaoImp implements CheckoutDao {

	@Override
	public void save(Checkout checkout) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(checkout);
		t.commit();	
	}

	@Override
	public Checkout getCheckout(long idCheckout) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Checkout) session.load(Checkout.class, idCheckout);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Checkout> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Checkout").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Checkout checkout) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(checkout);
		t.commit();	
	}

	@Override
	public void update(Checkout checkout) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(checkout);
		t.commit();	
	}
}