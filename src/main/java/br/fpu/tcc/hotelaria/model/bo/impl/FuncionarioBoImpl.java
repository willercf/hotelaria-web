package br.fpu.tcc.hotelaria.model.bo.impl;

import javax.annotation.Resource;

import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public class FuncionarioBoImpl extends AbstractBo<Funcionario, Long> implements FuncionarioBo {

	@Resource
	private FuncionarioDao funcionarioDao;

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	@Override
	public IBaseDao<Funcionario, Long> getDao() {
		return funcionarioDao;
	}

	@Override
	public Long save(Funcionario entity) throws BoException {
		entity.setAtivo(true);
		return super.save(entity);
	}

	public void changeStatus(Funcionario funcionario) throws BoException {

		try {
			funcionario.setAtivo(!funcionario.isAtivo());
			funcionarioDao.update(funcionario);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

}
