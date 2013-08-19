package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Reserva;

public interface ReservaDao {

	public void save(Reserva reserva);

	public Reserva getReserva(long idReserva);

	public List<Reserva> list();

	public void remove(Reserva reserva);

	public void update(Reserva reserva);
}
