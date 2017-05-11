/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.CotizacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class IndexController implements Serializable {
	
	//Variables de los dialogos y snackbars
	String dialogTittle = null;
	String dialogContent = null;

	@EJB
	private CotizacionFacadeLocal cotizacionEJB;
	private Cotizacion cotizacion;
	private List<Cotizacion> listaSeguimientoCotizacions;

	@PostConstruct
	public void init() {
		listaSeguimientoCotizacions = cotizacionEJB.listaSeguimiento(idUsuario());
	}

	public void obtenerCotizacionesRegistradas() throws Exception {
		try {
			listaSeguimientoCotizacions = cotizacionEJB.listaSeguimiento(idUsuario());
		} catch (Exception e) {
			dialogTittle = "Error no controlado";
			dialogContent = e.getMessage();
			RequestContext.getCurrentInstance().execute("mostrarDialogos(`" + dialogTittle + "`, `" + dialogContent + "`);");
		}
	}

	public int idUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getIdUsuario();
	}

}
