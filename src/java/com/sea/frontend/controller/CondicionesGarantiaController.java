/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.CondicionesGarantia;
import com.sea.backend.model.CondicionesGarantiaFacadeLocal;
import java.io.Serializable;
import java.util.List;
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
public class CondicionesGarantiaController implements Serializable {

	@EJB
	private CondicionesGarantiaFacadeLocal condicionesGarantiaEJB;
	private List<CondicionesGarantia> listaCondicionesGarantia;
	private CondicionesGarantia condicionesg;

	@PostConstruct
	public void init() {
		condicionesg = new CondicionesGarantia();
		listaCondicionesGarantia = condicionesGarantiaEJB.findAll();
	}

	
	public void registrar() {
		try {
			condicionesGarantiaEJB.create(condicionesg);
			listaCondicionesGarantia = condicionesGarantiaEJB.findAll();
		} catch (Exception e) {

		}

	}

	public List<CondicionesGarantia> getListaCondicionesGarantia() {
		return listaCondicionesGarantia;
	}

	public void setListaCondicionesGarantia(List<CondicionesGarantia> listaCondicionesGarantia) {
		this.listaCondicionesGarantia = listaCondicionesGarantia;
	}

	public CondicionesGarantia getCondicionesg() {
		return condicionesg;
	}

	public void setCondicionesg(CondicionesGarantia condicionesg) {
		this.condicionesg = condicionesg;
	}

	

}
