package br.fpu.tcc.hotelaria.model.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import br.fpu.tcc.hotelaria.enums.StatusReserva;
import br.fpu.tcc.hotelaria.model.dao.ReservaDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public class ReservaDaoImpl extends AbstractDao<Reserva, Long> implements ReservaDao {

	@Override
	public Reserva findByPrimarykey(Long pk) throws PersistenceException {
		Reserva entity = super.findByPrimarykey(pk);
		Hibernate.initialize(entity.getCliente());
		Hibernate.initialize(entity.getFuncionario());
		Hibernate.initialize(entity.getQuarto());
		return entity;
	}

	@Override
	protected Criteria createCriteria(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.createAlias("quarto", "q", Criteria.INNER_JOIN);
		criteria.createAlias("cliente", "c", Criteria.INNER_JOIN);
		criteria.createAlias("funcionario", "f", Criteria.INNER_JOIN);
		criteria.createAlias("checkIn", "ci", Criteria.LEFT_JOIN);
		criteria.createAlias("checkOut", "co", Criteria.LEFT_JOIN);

		if (entity != null) {
			criteria.add(Restrictions.ge("dataInicio", entity.getDataInicio()));
			criteria.add(Restrictions.le("dataFim", entity.getDataFim()));

			if (entity.getCliente() != null && entity.getCliente().getId() != null) {
				criteria.add(Restrictions.eq("cliente", entity.getCliente()));
			}

			if (entity.getQuarto() != null) {
				if (StringUtils.isNotBlank(entity.getQuarto().getNumero())) {
					criteria.add(Restrictions.ilike("q.numero", entity.getQuarto().getNumero(), MatchMode.ANYWHERE));
				}

				if (entity.getQuarto().getAndar() != null) {
					criteria.add(Restrictions.eq("q.andar", entity.getQuarto().getAndar()));
				}

				if (entity.getQuarto().getCategoria() != null) {
					criteria.add(Restrictions.eq("q.categoria", entity.getQuarto().getCategoria()));
				}
			}

		}

		return criteria;
	}

	public boolean existsRestriction(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		criteria.setProjection(Projections.rowCount());
		criteria.add(Restrictions.eq("quarto", entity.getQuarto()));

		// Criterion initRange = Restrictions.between("dataInicio",
		// entity.getDataInicio(), entity.getDataFim());
		// Criterion endRange = Restrictions.between("dataFim",
		// entity.getDataInicio(), entity.getDataFim());
		// Criterion condition =
		// Restrictions.disjunction().add(initRange).add(endRange);

		Criterion initRange = Restrictions.sqlRestriction("? between {alias}.data_inicio and {alias}.data_fim",
				entity.getDataInicio(), StandardBasicTypes.DATE);
		Criterion endRange = Restrictions.sqlRestriction("? between {alias}.data_inicio and {alias}.data_fim", entity.getDataFim(),
				StandardBasicTypes.DATE);
		Criterion condition = Restrictions.disjunction().add(initRange).add(endRange);
		criteria.add(condition);

		if (entity.getId() != null) {
			criteria.add(Restrictions.not(Restrictions.eq("id", entity.getId())));
		}

		StatusReserva[] status = { StatusReserva.RESERVED, StatusReserva.CHECK_IN };
		criteria.add(Restrictions.in("statusReserva", status));

		Long quantity = (Long) criteria.uniqueResult();
		return quantity > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> findForCheckIn(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.createAlias("quarto", "q", Criteria.INNER_JOIN);
		criteria.createAlias("cliente", "c", Criteria.INNER_JOIN);
		criteria.createAlias("funcionario", "f", Criteria.INNER_JOIN);
		criteria.createAlias("checkIn", "ci", Criteria.LEFT_JOIN);

		if (entity != null) {
			criteria.add(Restrictions.ge("dataInicio", entity.getDataInicio()));
			criteria.add(Restrictions.le("dataFim", entity.getDataFim()));

			if (entity.getCliente() != null && entity.getCliente().getId() != null) {
				criteria.add(Restrictions.eq("cliente", entity.getCliente()));
			}

			if (entity.getQuarto() != null) {
				if (StringUtils.isNotBlank(entity.getQuarto().getNumero())) {
					criteria.add(Restrictions.ilike("q.numero", entity.getQuarto().getNumero(), MatchMode.ANYWHERE));
				}

				if (entity.getQuarto().getAndar() != null) {
					criteria.add(Restrictions.eq("q.andar", entity.getQuarto().getAndar()));
				}

				if (entity.getQuarto().getCategoria() != null) {
					criteria.add(Restrictions.eq("q.categoria", entity.getQuarto().getCategoria()));
				}
			}
		}

		criteria.add(Restrictions.eq("statusReserva", StatusReserva.RESERVED));

		List<Reserva> result = (List<Reserva>) criteria.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> findForCheckOut(Reserva entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.createAlias("quarto", "q", Criteria.INNER_JOIN);
		criteria.createAlias("cliente", "c", Criteria.INNER_JOIN);
		criteria.createAlias("funcionario", "f", Criteria.INNER_JOIN);
		criteria.createAlias("checkIn", "ci", Criteria.INNER_JOIN);
		criteria.createAlias("checkOut", "co", Criteria.LEFT_JOIN);

		if (entity != null) {
			criteria.add(Restrictions.ge("dataInicio", entity.getDataInicio()));
			criteria.add(Restrictions.le("dataFim", entity.getDataFim()));

			if (entity.getCliente() != null && entity.getCliente().getId() != null) {
				criteria.add(Restrictions.eq("cliente", entity.getCliente()));
			}

			if (entity.getQuarto() != null) {
				if (StringUtils.isNotBlank(entity.getQuarto().getNumero())) {
					criteria.add(Restrictions.ilike("q.numero", entity.getQuarto().getNumero(), MatchMode.ANYWHERE));
				}

				if (entity.getQuarto().getAndar() != null) {
					criteria.add(Restrictions.eq("q.andar", entity.getQuarto().getAndar()));
				}

				if (entity.getQuarto().getCategoria() != null) {
					criteria.add(Restrictions.eq("q.categoria", entity.getQuarto().getCategoria()));
				}
			}
		}

		criteria.add(Restrictions.eq("statusReserva", StatusReserva.CHECK_IN));

		List<Reserva> result = (List<Reserva>) criteria.list();
		return result;
	}

}
