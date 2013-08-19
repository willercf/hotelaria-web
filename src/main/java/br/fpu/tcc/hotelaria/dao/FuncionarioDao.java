package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Funcionario;

public interface FuncionarioDao {

	public void save(Funcionario funcionario);

	public Funcionario getFuncionario(long idFuncionario);

	public List<Funcionario> list();

	public void remove(Funcionario funcionario);

	public void update(Funcionario funcionario);
}
