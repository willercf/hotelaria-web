package br.fpu.tcc.hotelaria.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;

public abstract class AbstractDao<T, PK extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, PK> {

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {

		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findByPrimarykey(PK pk) throws PersistenceException {

		try {
			return (T) getSession().get(getPersistentClass(), pk);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws PersistenceException {

		try {
			return getHibernateTemplate().loadAll(getPersistentClass());
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) throws PersistenceException {

		try {
			return (PK) getHibernateTemplate().save(entity);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void saveOrUpdate(T entity) throws PersistenceException {

		try {

		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void update(T entity) throws PersistenceException {

		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criteria criteria) throws PersistenceException {

		try {
			return criteria.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

}
