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
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdisonArturo
 */
@Entity
@Table(name = "view_modify_client")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ViewModifyClient.findAll", query = "SELECT v FROM ViewModifyClient v"),
	@NamedQuery(name = "ViewModifyClient.findByIdCliente", query = "SELECT v FROM ViewModifyClient v WHERE v.idCliente = :idCliente"),
	@NamedQuery(name = "ViewModifyClient.findByIdtelefono", query = "SELECT v FROM ViewModifyClient v WHERE v.idtelefono = :idtelefono"),
	@NamedQuery(name = "ViewModifyClient.findByIdcorreo", query = "SELECT v FROM ViewModifyClient v WHERE v.idcorreo = :idcorreo"),
	@NamedQuery(name = "ViewModifyClient.findByIdtipotelefono", query = "SELECT v FROM ViewModifyClient v WHERE v.idtipotelefono = :idtipotelefono"),
	@NamedQuery(name = "ViewModifyClient.findByIdtipodocumento", query = "SELECT v FROM ViewModifyClient v WHERE v.idtipodocumento = :idtipodocumento"),
	@NamedQuery(name = "ViewModifyClient.findByIdtipocorreo", query = "SELECT v FROM ViewModifyClient v WHERE v.idtipocorreo = :idtipocorreo"),
	@NamedQuery(name = "ViewModifyClient.findByIddireccion", query = "SELECT v FROM ViewModifyClient v WHERE v.iddireccion = :iddireccion"),
	@NamedQuery(name = "ViewModifyClient.findByIdtipodireccion", query = "SELECT v FROM ViewModifyClient v WHERE v.idtipodireccion = :idtipodireccion"),
	@NamedQuery(name = "ViewModifyClient.findByIdciudad", query = "SELECT v FROM ViewModifyClient v WHERE v.idciudad = :idciudad"),
	@NamedQuery(name = "ViewModifyClient.findByIddepartamento", query = "SELECT v FROM ViewModifyClient v WHERE v.iddepartamento = :iddepartamento"),
	@NamedQuery(name = "ViewModifyClient.findByIdusuario", query = "SELECT v FROM ViewModifyClient v WHERE v.idusuario = :idusuario")})
public class ViewModifyClient implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_Cliente")
	@Id
	private int idCliente;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_telefono")
	private int idtelefono;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_correo")
	private int idcorreo;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_telefono")
	private int idtipotelefono;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_documento")
	private int idtipodocumento;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_correo")
	private int idtipocorreo;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_direccion")
	private int iddireccion;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_direccion")
	private int idtipodireccion;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_ciudad")
	private int idciudad;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_departamento")
	private int iddepartamento;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_usuario")
	private int idusuario;

	public ViewModifyClient() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdtelefono() {
		return idtelefono;
	}

	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}

	public int getIdcorreo() {
		return idcorreo;
	}

	public void setIdcorreo(int idcorreo) {
		this.idcorreo = idcorreo;
	}

	public int getIdtipotelefono() {
		return idtipotelefono;
	}

	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}

	public int getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(int idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public int getIdtipocorreo() {
		return idtipocorreo;
	}

	public void setIdtipocorreo(int idtipocorreo) {
		this.idtipocorreo = idtipocorreo;
	}

	public int getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public int getIdtipodireccion() {
		return idtipodireccion;
	}

	public void setIdtipodireccion(int idtipodireccion) {
		this.idtipodireccion = idtipodireccion;
	}

	public int getIdciudad() {
		return idciudad;
	}

	public void setIdciudad(int idciudad) {
		this.idciudad = idciudad;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
}
