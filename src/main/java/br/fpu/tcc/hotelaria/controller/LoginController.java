package br.fpu.tcc.hotelaria.controller;

import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpSession;

import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.utils.CipherUtil;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class LoginController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FuncionarioBo funcionarioBo;

	private String login;

	private String senha;

	private Funcionario funcionario;

	public FuncionarioBo getFuncionarioBo() {
		return funcionarioBo;
	}

	public void setFuncionarioBo(FuncionarioBo funcionarioBo) {
		this.funcionarioBo = funcionarioBo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public String authenticate() {

		try {
			funcionario = funcionarioBo.authenticate(login, CipherUtil.encryptMd5(senha));
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FORMULARIO_LOGIN_ERRO);
		} catch (NoSuchAlgorithmException e) {
			super.addGlobalMessage("Senha inválida", FacesMessage.SEVERITY_FATAL);
		}

		if (funcionario == null) {
			return "";
		}

		login = null;
		senha = null;

		return "/main.xhtml?faces-redirect=true";
	}

	public void verifyAuthentication() {

		if (funcionario == null) {
			super.addGlobalMessage(BundleConstants.FORMULARIO_LOGIN_NOT_AUTHENTICATED, FacesMessage.SEVERITY_ERROR);
			super.redirect("/login.xhtml?faces-redirect=true");
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) super.getCurrentcontext().getExternalContext().getSession(false);
		session.invalidate();
		return "/login.xhtml?faces-redirect=true";
	}

	public String changePassword() {

		return "/alterarSenha.xhtml?faces-redirect=true";
	}
}
