package br.fpu.tcc.hotelaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import br.fpu.tcc.hotelaria.enums.TipoPessoa;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class ClienteController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ClienteBo clienteBo;

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteBo getClienteBo() {
		return clienteBo;
	}

	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public String showInsert() {

		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
		return "/clienteInsert?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = clienteBo.save(cliente);
			System.out.println("id: " + id);
			cliente = new Cliente();
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_SUCESSO);
		} catch (BoException e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_ERRO, FacesMessage.SEVERITY_ERROR);
		}
	}

	public void search() {

		try {
			clientes = clienteBo.findByFilter(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.FORMULARIO_PESQUISA_ERRO, FacesMessage.SEVERITY_ERROR);
		}
	}

	public String showUpdate() {

		return "/clienteEdit?faces-redirect=true";
	}

	public String update() {

		try {
			clienteBo.update(cliente);
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_SUCESSO);
			return "/clienteList?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			super.addGlobalMessage(BundleConstants.CLIENTE_CADASTRO_ERRO, FacesMessage.SEVERITY_ERROR);
		}

		return null;
	}
}
