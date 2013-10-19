package br.fpu.tcc.hotelaria.controller.converter;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;

import br.fpu.tcc.hotelaria.pojo.Cliente;
import br.fpu.tcc.hotelaria.utils.ObjectUtils;

public class ClienteConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {

		if (StringUtils.isBlank(submittedValue)) {
			return null;
		}

		Cliente cliente = null;
		try {
			cliente = (Cliente) ObjectUtils
					.deserializeFromString(submittedValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {

		String result = "";
		if (value == null || value.equals("")) {
			return result;
		}

		try {
			result = ObjectUtils.serializeToString((Cliente) value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
