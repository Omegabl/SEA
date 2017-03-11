/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.TipoEmail;
import com.sea.backend.model.TipoEmailFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class TipoEmailController implements Serializable {

	@EJB
	private TipoEmailFacadeLocal tipoEmailEJB;

	private TipoEmail tipoE;

	public TipoEmail getTipoE() {
		return tipoE;
	}

	public void setTipoE(TipoEmail tipoE) {
		this.tipoE = tipoE;
	}

	@PostConstruct
	public void init() {
		tipoE = new TipoEmail();
	}

	public void registrar() {
		try {
			tipoEmailEJB.create(tipoE);

		} catch (Exception e) {

		}

	}

}
