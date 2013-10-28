package br.fpu.tcc.hotelaria.model.dao;

import java.util.List;

import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public interface ReservaDao extends IBaseDao<Reserva, Long> {

	boolean existsRestriction(Reserva entity);

	List<Reserva> findForCheckIn(Reserva entity);

	List<Reserva> findForCheckOut(Reserva entity);
}
