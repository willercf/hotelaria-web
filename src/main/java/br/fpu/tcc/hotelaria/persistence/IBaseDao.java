package br.fpu.tcc.hotelaria.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import br.fpu.tcc.hotelaria.persistence.exception.PersistenceException;

public interface IBaseDao<T, PK extends Serializable> {

	T findByPrimarykey(PK pk) throws PersistenceException;

	List<T> findAll() throws PersistenceException;

	PK save(T entity) throws PersistenceException;

	void saveOrUpdate(T entity) throws PersistenceException;

	void update(T entity) throws PersistenceException;

	List<T> findByCriteria(Criteria criteria) throws PersistenceException;
}
