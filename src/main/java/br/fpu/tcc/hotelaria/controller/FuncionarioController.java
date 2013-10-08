package br.fpu.tcc.hotelaria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.web.ViewConstants;

public class FuncionarioController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FuncionarioBo funcionarioBo;

	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	private Boolean success = null;

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

	public String getCurrentMessage() {
		if (success == null) {
			return null;
		}

		return (success) ? ViewConstants.FUNCIONARIO_CADASTRO_ERRO : ViewConstants.FUNCIONARIO_CADASTRO_ERRO;
	}

	public void salvar() {
		Long id;
		try {
			id = funcionarioBo.save(funcionario);
			System.out.println("id: " + id);
			success = true;
		} catch (BoException e) {
			System.out.println("Error to save funcionario...");
			e.printStackTrace();
			success = false;
		}
	}

	public void pesquisar() {

		try {
			funcionarios = funcionarioBo.findByFilter(funcionario);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
