/*
 * The MIT License
 *
 * Copyright 2017 EdisonArturo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Usuario;
import com.sea.backend.entities.ViewReporteHistoricoVentas;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import com.sea.backend.model.ViewReporteHistoricoVentasFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HistoricoVentasController implements Serializable{
	@EJB
	private ViewReporteHistoricoVentasFacadeLocal ventasEJB;
	private ViewReporteHistoricoVentas ventas;
	private List<ViewReporteHistoricoVentas> listaVentas;
	
	@EJB
	private UsuarioFacadeLocal usuarioEJB;
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private List<Cliente> listaCliente;
	
	private Date fecha1;
	private Date fecha2;
	
	@PostConstruct
	public void init(){
		ventas = new ViewReporteHistoricoVentas();
		listaVentas = ventasEJB.findAll();	
		usuario = new Usuario();
		listaUsuario = usuarioEJB.findAll();
		cliente = new Cliente();
	}
	
	public void filtrar(){
		listaVentas = ventasEJB.filterVentas(fecha1, fecha2, usuario.getIdUsuario(), cliente.getNombreORazonSocial());
	}

	public List<ViewReporteHistoricoVentas> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<ViewReporteHistoricoVentas> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public ViewReporteHistoricoVentas getVentas() {
		return ventas;
	}

	public void setVentas(ViewReporteHistoricoVentas ventas) {
		this.ventas = ventas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}
	
	
}
