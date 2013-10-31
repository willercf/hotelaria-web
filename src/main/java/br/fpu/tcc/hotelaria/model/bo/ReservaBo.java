package br.fpu.tcc.hotelaria.model.bo;

import java.util.List;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.pojo.Reserva;

public interface ReservaBo extends IBaseBo<Reserva, Long> {

	List<Reserva> findForCheckIn(Reserva entity) throws BoException;

	List<Reserva> findForCheckOut(Reserva entity) throws BoException;

	void registerCheckIn(Reserva entity, Funcionario funcionario) throws BoException;

	void registerCheckOut(Reserva entity, Funcionario funcionario) throws BoException;
}
