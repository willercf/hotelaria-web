package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Cliente;

public interface ClienteDao {

	public void save(Cliente cliente);

	public Cliente getCliente(long idCliente);

	public List<Cliente> list();

	public void remove(Cliente cliente);

	public void update(Cliente cliente);
}
