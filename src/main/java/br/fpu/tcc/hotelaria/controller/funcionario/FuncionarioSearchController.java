package br.fpu.tcc.hotelaria.controller.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class FuncionarioSearchController extends BaseController {

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

	public void search() {

		try {
			funcionarios = funcionarioBo.findByFilter(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO, FacesMessage.SEVERITY_ERROR);
		}
	}

	public void changeStatus() {

		try {
			funcionarioBo.changeStatus(funcionario);
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
			funcionario = new Funcionario();
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_ERRO, FacesMessage.SEVERITY_ERROR);
		} finally {
			search();
		}
	}

	public String showUpdate() {

		return "/funcionarioUpdate?faces-redirect=true&id_funcionario=" + funcionario.getId();
	}

}
