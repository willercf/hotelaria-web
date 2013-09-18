package br.fpu.tcc.hotelaria.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

@ManagedBean(name = "mbFunc")
@SessionScoped
public class FuncionarioController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private FuncionarioBo funcionarioBo;

	private Funcionario funcionario = new Funcionario();

	public FuncionarioBo getFuncionarioBo() {
		return funcionarioBo;
	}

	public void setFuncionarioBo(FuncionarioBo funcionarioBo) {
		this.funcionarioBo = funcionarioBo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void salvar() {
		Long id;
		try {
			id = funcionarioBo.save(funcionario);
			System.out.println("id: " + id);
		} catch (BoException e) {
			System.out.println("Error to save funcionario...");
			e.printStackTrace();
		}

	}
}
