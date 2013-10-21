package br.fpu.tcc.hotelaria.controller;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import br.fpu.tcc.hotelaria.model.bo.exception.BoException;

public abstract class BaseController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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
		facesMessage.setSummary(bundle.getString(keyMessage));
		if (severity != null) {
			facesMessage.setSeverity(severity);
		}
		getCurrentcontext().addMessage(null, facesMessage);
		getCurrentcontext().getExternalContext().getFlash()
				.setKeepMessages(true);
	}

	protected FacesContext getCurrentcontext() {
		return FacesContext.getCurrentInstance();
	}

	protected void treatErrorMessage(BoException e, String genericErrorMessage) {

		e.printStackTrace();
		if (e.hasKeyMessage()) {
			addGlobalMessage(e.getKeyMessage());
		} else {
			addGlobalMessage(genericErrorMessage, FacesMessage.SEVERITY_ERROR);
		}
	}
}
