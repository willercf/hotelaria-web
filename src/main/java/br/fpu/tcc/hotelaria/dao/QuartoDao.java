package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Quarto;

public interface QuartoDao {

	public void save(Quarto quarto);

	public Quarto getQuarto(long idQuarto);

	public List<Quarto> list();

	public void remove(Quarto quarto);

	public void update(Quarto quarto);
}
