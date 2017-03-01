/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Menu;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.MenuFacadeLocal;
import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class MenuController implements Serializable {

	@EJB
	private MenuFacadeLocal EJBMenu;
	private List<Menu> lista;
	private MenuModel model;

	@PostConstruct
	public void init() {
		this.listarMenus();
		model = new DefaultMenuModel();
		// this.establecerPermisos();

	}

	public void listarMenus() {

		try {
			lista = EJBMenu.findAll();
		} catch (Exception e) {
			//mensaje de jsf

		}

	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	/* public void establecerPermisos() {

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        for (Menu m : lista) {
            if (m.getPerfilList().equals("S") && m.getTipoUsuario().equals(us.getTipo())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigo() == m.getCodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            item.setUrl(i.getUrl());
                            firstSubmenu.addElement(item);

                        }

                    }
                }
                model.addElement(firstSubmenu);
            } else if (m.getSubmenu() == null && m.getTipoUsuario().equals(us.getTipo())) {
                DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                item.setUrl(m.getUrl());
                model.addElement(item);

            }

        }
    }
	 */
	public void cerrarSesion() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		context.getExternalContext().redirect("");
	}

}
