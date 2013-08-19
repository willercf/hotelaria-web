package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class ClienteDaoImp implements ClienteDao {

	@Override
	public void save(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(cliente);
		t.commit();	
	}

	@Override
	public Cliente getCliente(long idCliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Cliente) session.load(Cliente.class, idCliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Cliente").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(cliente);
		t.commit();	
	}

	@Override
	public void update(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(cliente);
		t.commit();	
	}
}