package br.fpu.tcc.hotelaria.model.bo;

import java.io.Serializable;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.persistence.IBaseDao;

public abstract class AbstractBo<T, PK extends Serializable> implements IBaseBo<T, PK> {

	public abstract IBaseDao<T, PK> getDao();

	public T findByPrimarykey(PK pk) throws BoException {

		try {
			return getDao().findByPrimarykey(pk);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

	public List<T> findAll() throws BoException {

		try {
			return getDao().findAll();
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

	public PK save(T entity) throws BoException {
		try {
			return getDao().save(entity);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

	public void saveOrUpdate(T entity) throws BoException {

		try {
			getDao().saveOrUpdate(entity);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

	public void update(T entity) throws BoException {

		try {
			getDao().update(entity);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

	public List<T> findByFilter(T entity) throws BoException {

		try {
			return getDao().findByFilter(entity);
		} catch (Exception e) {
			throw new BoException(e);
		}
	}

}
