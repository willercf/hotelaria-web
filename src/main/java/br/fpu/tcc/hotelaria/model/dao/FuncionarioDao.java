package br.fpu.tcc.hotelaria.model.dao;

import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public interface FuncionarioDao extends IBaseDao<Funcionario, Long> {

	void changeStatus(Funcionario funcionario) throws PersistenceException;
}
