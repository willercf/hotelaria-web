package br.fpu.tcc.hotelaria.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.pojo.Checkin;

public interface CheckinDao {

	public void save(Checkin checkin);

	public Checkin getCheckin(long idCheckin);

	public List<Checkin> list();

	public void remove(Checkin checkin);

	public void update(Checkin checkin);
}
