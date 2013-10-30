package br.fpu.tcc.hotelaria.model.bo;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public interface FuncionarioBo extends IBaseBo<Funcionario, Long> {

	void changeStatus(Funcionario funcionario) throws BoException;

	Funcionario authenticate(String login, String senha) throws BoException;
}
