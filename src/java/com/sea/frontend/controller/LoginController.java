/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Usuario;
import com.sea.backend.entities.ViewPaginasUsuario;
import com.sea.backend.model.PaginaFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import com.sun.faces.context.FacesFileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONObject;

/**
 *
 * @author Depurador
 */
@Named
@ViewScoped
public class LoginController implements Serializable {

	@EJB
	private PaginaFacadeLocal PaginaEJB;

	@EJB
	private UsuarioFacadeLocal EJBUsuario;
	private Usuario usuario;

	private List<ViewPaginasUsuario> paginasPermitidas;

	//Variable de los dialogos
	JSONObject dialogData = new JSONObject();

	@PostConstruct
	public void init() {
		usuario = new Usuario();
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
					contex.getExternalContext().redirect("/SEA/");
				} else {
					dialogData.put("titulo", "Error al iniciar sesión.");
					dialogData.put("mensaje", "Usted no se encuentra activo en el sistema.<br />Por favor, comuníquese con el administrador del sistema.");
					RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
				}
			} else {
				dialogData.put("titulo", "Error al iniciar sesión");
				dialogData.put("mensaje", "El nombre de usuario y/o la contraseña son incorrectos.");
				RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
			}
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getMessage());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
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

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
			String paginaActual = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI();
			if (us == null) {
				context.getExternalContext().redirect("/SEA/auth/");
			} else if (!verificarPermisos(us, paginaActual)) {
				//context.getExternalContext().redirect("/SEA/");
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
				context.getExternalContext().redirect("/SEA/");
			}
		} catch (Exception e) {
			// log para guardar un registro de error
		}

	}

	public boolean verificarPermisos(Usuario us, String paginaActual) {
		System.out.println("Verificando permisos");
		paginasPermitidas = PaginaEJB.obtenerPagianasPermitidas(us.getIdUsuario());
		System.out.println("Página actal: " + paginaActual);
		for (ViewPaginasUsuario item : paginasPermitidas) {
			if (item.getPagina().startsWith(paginaActual)) {
				System.out.println("item.getPagina(): " + item.getPagina());
				return true;
			}
		}
		return false;
	}

	public void cerrarSesion() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		context.getExternalContext().redirect("");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
