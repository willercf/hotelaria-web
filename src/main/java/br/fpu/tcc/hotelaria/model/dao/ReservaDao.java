package br.fpu.tcc.hotelaria.model.dao;

import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public interface ReservaDao extends IBaseDao<Reserva, Long> {

	boolean existsRestriction(Reserva entity);
}
