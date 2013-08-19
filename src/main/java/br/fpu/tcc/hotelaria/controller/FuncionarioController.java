package br.fpu.tcc.hotelaria.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fpu.tcc.hotelaria.dao.FuncionarioDao;
import br.fpu.tcc.hotelaria.dao.FuncionarioDaoImp;
import br.fpu.tcc.hotelaria.pojo.Funcionario;

@ManagedBean 
@SessionScoped
public class FuncionarioController {

	private Funcionario funcionario;

	@SuppressWarnings("rawtypes")
	private DataModel listaFuncionarios;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarFuncionarios() {
		List<Funcionario> lista = new FuncionarioDaoImp().list();
		listaFuncionarios = new ListDataModel(lista);
		return listaFuncionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void prepararAdicionarFuncionario(ActionEvent actionEvent) {
		funcionario = new Funcionario();
	}

	public void prepararAlterarFuncionario(ActionEvent actionEvent) {
		funcionario = (Funcionario) (listaFuncionarios.getRowData());
	}

	public String excluirFuncionario() {
		Funcionario funcionarioTemp = (Funcionario) (listaFuncionarios.getRowData());
		FuncionarioDao dao = new FuncionarioDaoImp();
		dao.remove(funcionarioTemp);
		return "index";
	}

	public void adicionarFuncionario(ActionEvent actionEvent) {
		FuncionarioDao dao = new FuncionarioDaoImp();
		dao.save(funcionario);
	}

	public void alterarFuncionario(ActionEvent actionEvent) {
		FuncionarioDao dao = new FuncionarioDaoImp();
		dao.update(funcionario);
	}
}
