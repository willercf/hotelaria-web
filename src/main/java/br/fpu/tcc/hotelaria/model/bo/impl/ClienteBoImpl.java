package br.fpu.tcc.hotelaria.model.bo.impl;

import javax.annotation.Resource;

import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.ClienteBo;
import br.fpu.tcc.hotelaria.model.dao.ClienteDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Cliente;

public class ClienteBoImpl extends AbstractBo<Cliente, Long> implements ClienteBo {

	@Resource
	private ClienteDao clienteDao;

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public IBaseDao<Cliente, Long> getDao() {
		return clienteDao;
	}

}
