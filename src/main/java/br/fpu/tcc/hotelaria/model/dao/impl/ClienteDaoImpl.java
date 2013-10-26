package br.fpu.tcc.hotelaria.model.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.fpu.tcc.hotelaria.model.dao.ClienteDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.Cliente;

public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements
		ClienteDao {

	@Override
	protected Criteria createCriteria(Cliente entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		if (entity != null) {

			if (StringUtils.isNotBlank(entity.getNome())) {
				criteria.add(Restrictions.like("nome", entity.getNome(),
						MatchMode.ANYWHERE));
			}

			if (entity.getTipoPessoa() != null) {
				criteria.add(Restrictions.eq("tipoPessoa",
						entity.getTipoPessoa()));
			}

			if (StringUtils.isNotBlank(entity.getCpfCnpj())) {
				criteria.add(Restrictions.eq("cpfCnpj", entity.getCpfCnpj()));
			}

			if (StringUtils.isNotBlank(entity.getEmail())) {
				criteria.add(Restrictions.like("email", entity.getEmail(),
						MatchMode.ANYWHERE));
			}
		}

		return criteria;
	}
}
