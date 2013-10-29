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
			T t = (T) getSession().get(getPersistentClass(), pk);
			closeSession();
			return t;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws PersistenceException {

		try {
			List<T> result = getHibernateTemplate().loadAll(getPersistentClass());
			closeSession();
			return result;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) throws PersistenceException {

		try {
			PK pk = (PK) getHibernateTemplate().save(entity);
			closeSession();
			return pk;
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
			closeSession();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByFilter(T entity) throws PersistenceException {

		try {
			Criteria criteria = createCriteria(entity);
			List<T> result = criteria.list();
			closeSession();
			return result;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	protected abstract Criteria createCriteria(T entity);

	private void closeSession() {
		getSession().close();
	}
}
