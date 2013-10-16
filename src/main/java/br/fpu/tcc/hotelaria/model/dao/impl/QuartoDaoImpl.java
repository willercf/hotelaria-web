package br.fpu.tcc.hotelaria.model.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.fpu.tcc.hotelaria.model.dao.QuartoDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.Quarto;

public class QuartoDaoImpl extends AbstractDao<Quarto, Long> implements
		QuartoDao {

	@Override
	protected Criteria createCriteria(Quarto entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		if (entity != null) {

			if (StringUtils.isNotBlank(entity.getNumero())) {
				criteria.add(Restrictions.like("numero", entity.getNumero(),
						MatchMode.ANYWHERE));
			}

			if (entity.getCategoria() != null) {
				criteria.add(Restrictions.eq("categoria", entity.getCategoria()));
			}

			if (entity.getAndar() != null) {
				criteria.add(Restrictions.eq("andar", entity.getAndar()));
			}
		}

		return criteria;
	}

}
