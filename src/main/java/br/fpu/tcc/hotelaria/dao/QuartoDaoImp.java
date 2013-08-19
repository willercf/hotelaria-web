package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Quarto;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class QuartoDaoImp implements QuartoDao {

	@Override
	public void save(Quarto quarto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(quarto);
		t.commit();	
	}

	@Override
	public Quarto getQuarto(long idQuarto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Quarto) session.load(Quarto.class, idQuarto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Quarto> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Cliente").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Quarto quarto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(quarto);
		t.commit();	
	}

	@Override
	public void update(Quarto quarto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(quarto);
		t.commit();	
	}
}