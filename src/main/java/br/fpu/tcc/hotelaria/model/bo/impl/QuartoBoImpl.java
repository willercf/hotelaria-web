package br.fpu.tcc.hotelaria.model.bo.impl;

import javax.annotation.Resource;

import br.fpu.tcc.hotelaria.model.bo.AbstractBo;
import br.fpu.tcc.hotelaria.model.bo.QuartoBo;
import br.fpu.tcc.hotelaria.model.dao.QuartoDao;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;
import br.fpu.tcc.hotelaria.pojo.Quarto;

public class QuartoBoImpl extends AbstractBo<Quarto, Long> implements QuartoBo {

	@Resource
	private QuartoDao quartoDao;

	public QuartoDao getQuartoDao() {
		return quartoDao;
	}

	public void setQuartoDao(QuartoDao quartoDao) {
		this.quartoDao = quartoDao;
	}

	@Override
	public IBaseDao<Quarto, Long> getDao() {
		return quartoDao;
	}

}
