package br.fpu.tcc.hotelaria.model.bo.impl;

import javax.annotation.Resource;

import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.ReservaBo;
import br.fpu.tcc.hotelaria.model.dao.ReservaDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public class ReservaBoImpl extends AbstractBo<Reserva, Long> implements
		ReservaBo {

	@Resource
	private ReservaDao reservaDao;

	public ReservaDao getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}

	@Override
	public IBaseDao<Reserva, Long> getDao() {
		return reservaDao;
	}

}
