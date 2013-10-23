package br.fpu.tcc.hotelaria.model.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import br.fpu.tcc.hotelaria.enums.StatusQuarto;
import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.ReservaBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.model.dao.ReservaDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Reserva;
import br.fpu.tcc.hotelaria.utils.DateUtil;
import br.fpu.tcc.hotelaria.web.BundleConstants;

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

	@Override
	public List<Reserva> findByFilter(Reserva entity) throws BoException {

		DateUtil.applyTimeDefaultReserva(entity);
		return super.findByFilter(entity);
	}

	@Override
	public Long save(Reserva entity) throws BoException {

		DateUtil.applyTimeDefaultReserva(entity);
		validate(entity);
		entity.setStatusQuarto(StatusQuarto.RESERVED);

		return super.save(entity);
	}

	@Override
	public void update(Reserva entity) throws BoException {

		DateUtil.applyTimeDefaultReserva(entity);
		validate(entity);
		super.update(entity);
	}

	private void validate(Reserva entity) throws BoException {

		if (entity.getQuarto() == null) {
			throw new BoException("Quarto is null",
					BundleConstants.FORMULARIO_QUARTO_REQUERIDO);
		}

		if (reservaDao.existsRestriction(entity)) {
			throw new BoException("Quarto already has reservation",
					BundleConstants.FORMULARIO_QUARTO_POSSUI_RESERVA);
		}
	}

}
