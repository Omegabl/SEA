/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Usuario;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.Serializable;

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
public class LoginController implements Serializable {

	@EJB
	private UsuarioFacadeLocal EJBUsuario;
	private Usuario usuario;

	//Variables de los dialogos
	String dialogTittle = null;
	String dialogContent = null;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void iniciarSesion() {
		Usuario us;
		try {
			us = EJBUsuario.iniciarSesion(usuario);
			if (us != null) {
				if (us.getHabilitado()) {
					//Almacenar la sesión de JSF
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
					FacesContext contex = FacesContext.getCurrentInstance();
					contex.getExternalContext().redirect("/SEA/index.xhtml");
				} else {
					dialogTittle = "Error al iniciar sesión";
					dialogContent = "Usted no se encuentra activo en el sistema.<br />Por favor, comuníquese con el administrador del sistema.";
					RequestContext.getCurrentInstance().execute("mostrarDialogos(`" + dialogTittle + "`, `" + dialogContent + "`);");
				}
			} else {
				dialogTittle = "Error al iniciar sesión";
				dialogContent = "El nombre de usuario y/o la contraseña son incorrectos.";
				RequestContext.getCurrentInstance().execute("mostrarDialogos(`" + dialogTittle + "`, `" + dialogContent + "`);");
			}
		} catch (Exception e) {
			dialogTittle = "Error no controlado";
			dialogContent = e.getMessage();
			RequestContext.getCurrentInstance().execute("mostrarDialogos(`" + dialogTittle + "`, `" + dialogContent + "`);");
		}
	}

	// Capturando el nombre del usuario que inicia sesión
	public String mostrarNombreUsuario() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getNombre() + " " + u.getApellido();
	}

	public String mostrarCargo() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		return u.getTblCargoIdCargo().getCargo();
	}

	//Metodo para mostar el id Interno del usuario y el numero de cotizaci´´on correspondiente
	public String mostrarIdInterno() {
		HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		this.usuario = u;
		return u.getIdInterno() + " -" + u.getConsecutivoCotizacion();
	}

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
			if (us == null) {
				context.getExternalContext().redirect("/SEA/auth");
			}
		} catch (Exception e) {
			// log para guardar un registro de error
		}
	}

	public void verificarSesionLogin() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
			if (us != null) {
				context.getExternalContext().redirect("/SEA/index.xhtml");
			}
		} catch (Exception e) {
			// log para guardar un registro de error
		}

	}

	public void cerrarSesion() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		context.getExternalContext().redirect("");
	}
}
