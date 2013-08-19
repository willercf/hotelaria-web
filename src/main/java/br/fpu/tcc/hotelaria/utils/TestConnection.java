package br.fpu.tcc.hotelaria.utils;

import org.hibernate.Session;

public class TestConnection {

	public static void main(String[] args) {
		Session sessao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectado!");
		} finally {
			sessao.close();
		}
	}

}
