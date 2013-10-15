package br.fpu.tcc.hotelaria.model.bo.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.model.bo.exception.PasswordDoesntMatchException;
import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.pojo.StatusFuncionario;
import br.fpu.tcc.hotelaria.utils.CipherUtil;

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

		if (!StringUtils.equals(entity.getSenha(), entity.getConfirmacaoSenha())) {
			throw new PasswordDoesntMatchException("Password doesn't match...");
		}

		try {
			entity.setSenha(CipherUtil.encryptMd5(entity.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			throw new BoException(e);
		}

		entity.setStatus(StatusFuncionario.ACTIVE);
		return super.save(entity);
	}

	public void changeStatus(Funcionario funcionario) throws BoException {

		try {

			funcionario.setStatus((funcionario.getStatus() == StatusFuncionario.ACTIVE) ? StatusFuncionario.INACTIVE
					: StatusFuncionario.ACTIVE);
			funcionarioDao.update(funcionario);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

}
