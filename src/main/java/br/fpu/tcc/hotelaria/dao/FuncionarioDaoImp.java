package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.utils.HibernateUtil;

public class FuncionarioDaoImp implements FuncionarioDao {

	@Override
	public void save(Funcionario funcionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(funcionario);
		t.commit();	
	}

	@Override
	public Funcionario getFuncionario(long idFuncionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Funcionario) session.load(Funcionario.class, idFuncionario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Funcionario").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Funcionario funcionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(funcionario);
		t.commit();	
	}

	@Override
	public void update(Funcionario funcionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(funcionario);
		t.commit();	
	}
}