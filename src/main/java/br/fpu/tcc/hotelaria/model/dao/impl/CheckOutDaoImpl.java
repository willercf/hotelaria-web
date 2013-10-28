package br.fpu.tcc.hotelaria.model.dao.impl;

import org.hibernate.Criteria;

import br.fpu.tcc.hotelaria.model.dao.CheckOutDao;
import br.fpu.tcc.hotelaria.persistence.AbstractDao;
import br.fpu.tcc.hotelaria.pojo.CheckOut;

public class CheckOutDaoImpl extends AbstractDao<CheckOut, Long> implements CheckOutDao {

	@Override
	protected Criteria createCriteria(CheckOut entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
