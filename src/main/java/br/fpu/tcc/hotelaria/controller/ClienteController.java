package br.fpu.tcc.hotelaria.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fpu.tcc.hotelaria.dao.ClienteDao;
import br.fpu.tcc.hotelaria.dao.ClienteDaoImp;
import br.fpu.tcc.hotelaria.pojo.Cliente;

@SessionScoped
@ManagedBean(name="clienteController") 
public class ClienteController {

	private Cliente cliente;

	@SuppressWarnings("rawtypes")
	private DataModel listaClientes;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaClientes() {
		List<Cliente> lista = new ClienteDaoImp().list();
		listaClientes = new ListDataModel(lista);
		return listaClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void prepararAdicionarCliente(ActionEvent actionEvent) {
		cliente = new Cliente();
	}

	public void prepararAlterarCliente(ActionEvent actionEvent) {
		cliente = (Cliente) (listaClientes.getRowData());
	}

	public String excluirCliente() {
		Cliente clienteTemp = (Cliente) (listaClientes.getRowData());
		ClienteDao dao = new ClienteDaoImp();
		dao.remove(clienteTemp);
		return "index";
	}

	public void adicionarCliente(ActionEvent actionEvent) {
		ClienteDao dao = new ClienteDaoImp();
		dao.save(cliente);
	}

	public void alterarCliente(ActionEvent actionEvent) {
		ClienteDao dao = new ClienteDaoImp();
		dao.update(cliente);
	}
}
