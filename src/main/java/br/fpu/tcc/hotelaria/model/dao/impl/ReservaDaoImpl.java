package br.fpu.tcc.hotelaria.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.fpu.tcc.hotelaria.model.dao.ReservaDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public class ReservaDaoImpl extends AbstractDao<Reserva, Long> implements
		ReservaDao {

	@Override
	protected Criteria createCriteria(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		// criteria.

		if (entity != null) {

		}

		return criteria;
	}

	public boolean existsRestriction(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		criteria.setProjection(Projections.rowCount());
		criteria.add(Restrictions.eq("quarto", entity.getQuarto()));

		Criterion initRange = Restrictions.between("dataInicio",
				entity.getDataInicio(), entity.getDataFim());
		Criterion endRange = Restrictions.between("dataFim",
				entity.getDataInicio(), entity.getDataFim());
		Criterion condition = Restrictions.disjunction().add(initRange)
				.add(endRange);
		criteria.add(condition);

		if (entity.getId() != null) {
			criteria.add(Restrictions.not(Restrictions.eq("id", entity.getId())));
		}

		Long quantity = (Long) criteria.uniqueResult();
		return quantity > 0;
	}
}
