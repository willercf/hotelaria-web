package br.fpu.tcc.hotelaria.utils;

import java.util.Calendar;
import java.util.Date;

import br.fpu.tcc.hotelaria.pojo.Reserva;

public class DateUtil {

	public static Date getInitTimeReservation(Date initDate) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(initDate);
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		calendar.add(Calendar.MINUTE, 0);
		calendar.add(Calendar.SECOND, 1);
		return calendar.getTime();
	}

	public static Date getEndTimeReservation(Date initDate) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(initDate);
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		calendar.add(Calendar.MINUTE, 0);
		calendar.add(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static void applyTimeDefaultReserva(Reserva entity) {

		entity.setDataInicio(getInitTimeReservation(entity.getDataInicio()));
		entity.setDataFim(getEndTimeReservation(entity.getDataFim()));
	}
}
