package br.fpu.tcc.hotelaria.controller;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public abstract class BaseController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected FacesContext facesContext = FacesContext.getCurrentInstance();

	private ResourceBundle bundle;

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	protected void addGlobalMessage(String keyMessage) {
		addGlobalMessage(keyMessage, null);
	}

	protected void addGlobalMessage(String keyMessage, Severity severity) {

		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setDetail(bundle.getString(keyMessage));
		facesMessage.setSeverity(severity);
		facesContext.addMessage(null, facesMessage);
	}

}
