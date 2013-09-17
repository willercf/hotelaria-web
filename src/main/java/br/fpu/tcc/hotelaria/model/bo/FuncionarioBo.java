package br.fpu.tcc.hotelaria.model.bo;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

public interface FuncionarioBo {

	void changeStatus(Funcionario funcionario) throws BoException;
}
