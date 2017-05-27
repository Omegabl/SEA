/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.OrdenProduccion;
import com.sea.backend.entities.ObservacionesOrdenProduccion;
import com.sea.backend.model.OrdenProduccionFacadeLocal;
import com.sea.backend.model.ObservacionesOrdenProduccionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.json.JSONObject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Depurador
 */
@Named
@ViewScoped
public class ObservacionesOrdenProduccionController implements Serializable {

	//Variables de los dialogos y snackbars
	JSONObject dialogData = new JSONObject();
	JSONObject snackbarData = new JSONObject();

	@EJB
	private ObservacionesOrdenProduccionFacadeLocal observacionesOPEJB;
	private ObservacionesOrdenProduccion observacionesOP;
	private List<ObservacionesOrdenProduccion> observacionesRegistradas;
	private List<ObservacionesOrdenProduccion> nuevasObservaciones;

	@EJB
	private OrdenProduccionFacadeLocal ordenProduccionEJB;
	private OrdenProduccion ordenProduccion;
	private List<OrdenProduccion> listaOrdenesProduccion;
	private int idOP;

	@PostConstruct
	public void init() {
		observacionesOP = new ObservacionesOrdenProduccion();
		ordenProduccion = new OrdenProduccion();
		obtenerDatosOP();
		nuevasObservaciones = new ArrayList<>();
		System.out.println("Parámetro: " + idOP);
		listaOrdenesProduccion=ordenProduccionEJB.OPPorEstado("En seguimiento");
	}

	public void obtenerDatosOP(/*int op*/) {
		//System.out.println("Parámetro: "+getIdOP());
		ordenProduccion = ordenProduccionEJB.find(idOP);
		observacionesRegistradas = ordenProduccionEJB.observacionesOP(ordenProduccion);
	}

	public void agregarObservacion() {
		try {
			ObservacionesOrdenProduccion nuevaObservacion = new ObservacionesOrdenProduccion();
			nuevaObservacion.setFechaObservacion(new Date());
			nuevaObservacion.setTblOrdenProduccionIdOrdenProduccion(ordenProduccion);
			nuevaObservacion.setDescripcion(observacionesOP.getDescripcion());
			nuevasObservaciones.add(nuevaObservacion);
			observacionesRegistradas.add(nuevaObservacion);
			snackbarData.put("message", "proceso agregado.");
			RequestContext.getCurrentInstance().execute("mostrarSnackbar(" + snackbarData + ");");
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}

	public void registrarObservacion() {
		try {
			for (ObservacionesOrdenProduccion itemRegistro : nuevasObservaciones) {
				observacionesOPEJB.create(itemRegistro);
			}
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}
	public void actualizarOrden() {
		try {
			System.out.println("Modificando OP");
			ordenProduccionEJB.edit(ordenProduccion);
			System.out.println("Agregando/modificando observaciones");
			registrarObservacion();
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().redirect("./");
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}
	public void entregarOrden(){
		try {
			ordenProduccion.setEstado("Finalizada");
			actualizarOrden();
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}
	//Getters & Setters
	public ObservacionesOrdenProduccion getObservacionesOP() {
		return observacionesOP;
	}

	public void setObservacionesOP(ObservacionesOrdenProduccion observacionesOP) {
		this.observacionesOP = observacionesOP;
	}

	public List<ObservacionesOrdenProduccion> getObservacionesRegistradas() {
		return observacionesRegistradas;
	}

	public void setObservacionesRegistradas(List<ObservacionesOrdenProduccion> observacionesRegistradas) {
		this.observacionesRegistradas = observacionesRegistradas;
	}

	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public int getIdOP() {
		return idOP;
	}

	public void setIdOP(int idOP) {
		System.out.println("Seteando parámetro");
		this.idOP = idOP;
		System.out.println("Parámetro: " + getIdOP());
	}

	public List<ObservacionesOrdenProduccion> getNuevasObservaciones() {
		return nuevasObservaciones;
	}

	public void setNuevasObservaciones(List<ObservacionesOrdenProduccion> nuevasObservaciones) {
		this.nuevasObservaciones = nuevasObservaciones;
	}

	public List<OrdenProduccion> getListaOrdenesProduccion() {
		return listaOrdenesProduccion;
	}

	public void setListaOrdenesProduccion(List<OrdenProduccion> listaOrdenesProduccion) {
		this.listaOrdenesProduccion = listaOrdenesProduccion;
	}
	
}
