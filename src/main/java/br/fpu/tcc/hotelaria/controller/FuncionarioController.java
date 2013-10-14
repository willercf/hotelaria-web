package br.fpu.tcc.hotelaria.controller;

import java.util.ArrayList;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

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
		return "/funcionario/insert?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = funcionarioBo.save(funcionario);
			System.out.println("id: " + id);
		} catch (BoException e) {
			e.printStackTrace();
		}
	}

	public void search() {

		try {
			funcionarios = funcionarioBo.findByFilter(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeStatus() {

		try {
			funcionarioBo.changeStatus(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			search();
		}
	}

	public String showUpdate() {

		return "/funcionario/edit?faces-redirect=true";
	}

	public String update() {

		try {
			funcionarioBo.update(funcionario);
			return "/funcionario/list?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
