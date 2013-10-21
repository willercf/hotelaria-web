package br.fpu.tcc.hotelaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class FuncionarioController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FuncionarioBo funcionarioBo;

	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public FuncionarioBo getFuncionarioBo() {
		return funcionarioBo;
	}

	public void setFuncionarioBo(FuncionarioBo funcionarioBo) {
		this.funcionarioBo = funcionarioBo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String showInsert() {

		funcionario = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
		return "/funcionarioInsert?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = funcionarioBo.save(funcionario);
			System.out.println("id: " + id);
			funcionario = new Funcionario();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FUNCIONARIO_CADASTRO_ERRO);
		}
	}

	public void search() {

		try {
			funcionarios = funcionarioBo.findByFilter(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public void changeStatus() {

		try {
			funcionarioBo.changeStatus(funcionario);
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
			funcionario = new Funcionario();
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_ERRO,
					FacesMessage.SEVERITY_ERROR);
		} finally {
			search();
		}
	}

	public String showUpdate() {

		return "/funcionarioEdit?faces-redirect=true";
	}

	public String update() {

		try {
			funcionarioBo.update(funcionario);
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
			return "/funcionarioList?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_ERRO);
		}

		return null;
	}
}
