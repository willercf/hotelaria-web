package br.fpu.tcc.hotelaria.model.bo;

import java.io.Serializable;
import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;

public interface IBaseBo<T, PK extends Serializable> {

	T findByPrimarykey(PK pk) throws BoException;

	List<T> findAll() throws BoException;

	PK save(T entity) throws BoException;

	void saveOrUpdate(T entity) throws BoException;

	void update(T entity) throws BoException;

	List<T> findByFilter(T entity) throws BoException;

}
