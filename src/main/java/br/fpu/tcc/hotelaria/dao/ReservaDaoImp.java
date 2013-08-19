package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class ReservaDaoImp implements ReservaDao {

	@Override
	public void save(Reserva reserva) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(reserva);
		t.commit();	
	}

	@Override
	public Reserva getReserva(long idReserva) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Reserva) session.load(Reserva.class, idReserva);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Reserva").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Reserva reserva) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(reserva);
		t.commit();	
	}

	@Override
	public void update(Reserva reserva) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(reserva);
		t.commit();	
	}
}