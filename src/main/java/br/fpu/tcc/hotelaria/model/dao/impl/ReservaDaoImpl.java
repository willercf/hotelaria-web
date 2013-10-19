package br.fpu.tcc.hotelaria.model.dao.impl;

import org.hibernate.Criteria;

import br.fpu.tcc.hotelaria.model.dao.ReservaDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public class ReservaDaoImpl extends AbstractDao<Reserva, Long> implements
		ReservaDao {

	@Override
	protected Criteria createCriteria(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		if (entity != null) {

		}

		return criteria;
	}

}
