/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.TipoDireccion;
import com.sea.backend.model.TipoDireccionFacadeLocal;
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
public class TipoDireccionController implements Serializable {

	@EJB
	private TipoDireccionFacadeLocal tipoDireccionEJB;

	private TipoDireccion tipoD;

	public TipoDireccion getTipoD() {
		return tipoD;
	}

	public void setTipoD(TipoDireccion tipoD) {
		this.tipoD = tipoD;
	}

	@PostConstruct
	public void init() {
		tipoD = new TipoDireccion();

	}

	public void registrar() {
		try {
			tipoDireccionEJB.create(tipoD);

		} catch (Exception e) {

		}

	}

}
