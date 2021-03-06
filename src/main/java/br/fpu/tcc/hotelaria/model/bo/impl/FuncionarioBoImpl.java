package br.fpu.tcc.hotelaria.model.bo.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import br.fpu.tcc.hotelaria.enums.StatusFuncionario;
import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.AuthenticateException;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.model.bo.exception.PasswordDoesntMatchException;
import br.fpu.tcc.hotelaria.model.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.utils.CipherUtil;
import br.fpu.tcc.hotelaria.web.BundleConstants;

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
			throw new PasswordDoesntMatchException("Password doesn't match...", BundleConstants.FORMULARIO_SENHAS_INCONFORMIDADE);
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

	public Funcionario authenticate(String login, String senha) throws BoException {

		Funcionario funcionario = funcionarioDao.authenticate(login, senha);
		if (funcionario == null) {
			throw new AuthenticateException("User or password invalid.", BundleConstants.FORMULARIO_LOGIN_DOESNT_MATCH);
		}

		return funcionario;
	}

	public void changePassword(Funcionario funcionario, String senhaAntiga, String senha, String confirmacaoSenha)
			throws BoException {

		try {
			senhaAntiga = CipherUtil.encryptMd5(senhaAntiga);

			if (!StringUtils.equals(funcionario.getSenha(), senhaAntiga)) {
				throw new PasswordDoesntMatchException("Old password doesn't match...",
						BundleConstants.LOGIN_ALTERAR_SENHA_ANTIGA_ERRO);
			}

			if (!StringUtils.equals(senha, confirmacaoSenha)) {
				throw new PasswordDoesntMatchException("Password doesn't match...",
						BundleConstants.FORMULARIO_SENHAS_INCONFORMIDADE);
			}

			funcionario.setSenha(CipherUtil.encryptMd5(senha));

			funcionarioDao.update(funcionario);
		} catch (NoSuchAlgorithmException e) {
			throw new BoException(e, BundleConstants.LOGIN_ALTERAR_SENHA_ENCRYPT_ERRO);
		} catch (PersistenceException e) {
			throw new BoException(e);
		}

	}

}
