package br.fpu.tcc.hotelaria.model.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long>
		implements FuncionarioDao {

	public void changeStatus(Funcionario funcionario)
			throws PersistenceException {

		super.update(funcionario);
	}

	@Override
	protected Criteria createCriteria(Funcionario entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		if (entity != null) {

			if (StringUtils.isNotBlank(entity.getNome())) {
				criteria.add(Restrictions.like("nome", entity.getNome(),
						MatchMode.ANYWHERE));
			}

			if (StringUtils.isNotBlank(entity.getCpf())) {
				criteria.add(Restrictions.eq("cpf", entity.getCpf()));
			}

			if (StringUtils.isNotBlank(entity.getLogin())) {
				criteria.add(Restrictions.like("login", entity.getLogin(),
						MatchMode.ANYWHERE));
			}
		}
		return criteria;
	}

}
