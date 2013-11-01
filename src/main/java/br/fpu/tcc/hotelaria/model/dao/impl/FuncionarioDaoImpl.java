package br.fpu.tcc.hotelaria.model.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.fpu.tcc.hotelaria.enums.StatusFuncionario;
import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	public void changeStatus(Funcionario funcionario) throws PersistenceException {

		super.update(funcionario);
	}

	public Funcionario authenticate(String login, String senha) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("senha", senha));
		criteria.add(Restrictions.eq("status", StatusFuncionario.ACTIVE));

		Funcionario funcionario = (Funcionario) criteria.uniqueResult();
		return funcionario;
	}

	@Override
	protected Criteria createCriteria(Funcionario entity) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());

		if (entity != null) {

			if (StringUtils.isNotBlank(entity.getNome())) {
				criteria.add(Restrictions.like("nome", entity.getNome(), MatchMode.ANYWHERE));
			}

			if (StringUtils.isNotBlank(entity.getCpf())) {
				criteria.add(Restrictions.eq("cpf", entity.getCpf()));
			}

			if (StringUtils.isNotBlank(entity.getLogin())) {
				criteria.add(Restrictions.like("login", entity.getLogin(), MatchMode.ANYWHERE));
			}
		}
		return criteria;
	}

}
