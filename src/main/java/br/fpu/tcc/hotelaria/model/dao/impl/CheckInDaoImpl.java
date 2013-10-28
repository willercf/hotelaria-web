package br.fpu.tcc.hotelaria.model.dao.impl;

import org.hibernate.Criteria;

import br.fpu.tcc.hotelaria.model.dao.CheckInDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.CheckIn;

public class CheckInDaoImpl extends AbstractDao<CheckIn, Long> implements CheckInDao {

	@Override
	protected Criteria createCriteria(CheckIn entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
