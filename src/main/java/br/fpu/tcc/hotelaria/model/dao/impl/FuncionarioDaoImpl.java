package br.fpu.tcc.hotelaria.model.dao.impl;

import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	public void changeStatus(Funcionario funcionario) throws PersistenceException {


		super.update(funcionario);
	}

}
