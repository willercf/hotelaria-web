package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Checkin;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class CheckinDaoImp implements CheckinDao {

	@Override
	public void save(Checkin checkin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(checkin);
		t.commit();	
	}

	@Override
	public Checkin getCheckin(long idCheckin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Checkin) session.load(Checkin.class, idCheckin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Checkin> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Checkin").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Checkin checkin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(checkin);
		t.commit();	
	}

	@Override
	public void update(Checkin checkin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(checkin);
		t.commit();	
	}
}