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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdisonArturo
 */
@Entity
@Table(name = "view_modify_user")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ViewModifyUser.findAll", query = "SELECT v FROM ViewModifyUser v"),
	@NamedQuery(name = "ViewModifyUser.findByNombre", query = "SELECT v FROM ViewModifyUser v WHERE v.nombre = :nombre"),
	@NamedQuery(name = "ViewModifyUser.findByNumerodocumento", query = "SELECT v FROM ViewModifyUser v WHERE v.numerodocumento = :numerodocumento"),
	@NamedQuery(name = "ViewModifyUser.findByIdinterno", query = "SELECT v FROM ViewModifyUser v WHERE v.idinterno = :idinterno"),
	@NamedQuery(name = "ViewModifyUser.findByNumerotelefono", query = "SELECT v FROM ViewModifyUser v WHERE v.numerotelefono = :numerotelefono"),
	@NamedQuery(name = "ViewModifyUser.findByCorreo", query = "SELECT v FROM ViewModifyUser v WHERE v.correo = :correo"),
	@NamedQuery(name = "ViewModifyUser.findByNombreusuario", query = "SELECT v FROM ViewModifyUser v WHERE v.nombreusuario = :nombreusuario"),
	@NamedQuery(name = "ViewModifyUser.findByCargo", query = "SELECT v FROM ViewModifyUser v WHERE v.cargo = :cargo"),
	@NamedQuery(name = "ViewModifyUser.findByTipotelefono", query = "SELECT v FROM ViewModifyUser v WHERE v.tipotelefono = :tipotelefono"),
	@NamedQuery(name = "ViewModifyUser.findByTipodocumento", query = "SELECT v FROM ViewModifyUser v WHERE v.tipodocumento = :tipodocumento"),
	@NamedQuery(name = "ViewModifyUser.findByTipoemail", query = "SELECT v FROM ViewModifyUser v WHERE v.tipoemail = :tipoemail"),
	@NamedQuery(name = "ViewModifyUser.findByDireccion", query = "SELECT v FROM ViewModifyUser v WHERE v.direccion = :direccion"),
	@NamedQuery(name = "ViewModifyUser.findByTipodireccion", query = "SELECT v FROM ViewModifyUser v WHERE v.tipodireccion = :tipodireccion"),
	@NamedQuery(name = "ViewModifyUser.findByNombreciudad", query = "SELECT v FROM ViewModifyUser v WHERE v.nombreciudad = :nombreciudad"),
	@NamedQuery(name = "ViewModifyUser.findByNombredepartamento", query = "SELECT v FROM ViewModifyUser v WHERE v.nombredepartamento = :nombredepartamento"),
	@NamedQuery(name = "ViewModifyUser.findByIdusuario", query = "SELECT v FROM ViewModifyUser v WHERE v.idusuario = :idusuario"),
	@NamedQuery(name = "ViewModifyUser.findByIdtelefono", query = "SELECT v FROM ViewModifyUser v WHERE v.idtelefono = :idtelefono"),
	@NamedQuery(name = "ViewModifyUser.findByIdcorreo", query = "SELECT v FROM ViewModifyUser v WHERE v.idcorreo = :idcorreo"),
	@NamedQuery(name = "ViewModifyUser.findByIdcargo", query = "SELECT v FROM ViewModifyUser v WHERE v.idcargo = :idcargo"),
	@NamedQuery(name = "ViewModifyUser.findByIdtipotelefono", query = "SELECT v FROM ViewModifyUser v WHERE v.idtipotelefono = :idtipotelefono"),
	@NamedQuery(name = "ViewModifyUser.findByIdtipodocumento", query = "SELECT v FROM ViewModifyUser v WHERE v.idtipodocumento = :idtipodocumento"),
	@NamedQuery(name = "ViewModifyUser.findByIdtipocorreo", query = "SELECT v FROM ViewModifyUser v WHERE v.idtipocorreo = :idtipocorreo"),
	@NamedQuery(name = "ViewModifyUser.findByIddireccion", query = "SELECT v FROM ViewModifyUser v WHERE v.iddireccion = :iddireccion"),
	@NamedQuery(name = "ViewModifyUser.findByIdtipodireccion", query = "SELECT v FROM ViewModifyUser v WHERE v.idtipodireccion = :idtipodireccion"),
	@NamedQuery(name = "ViewModifyUser.findByIdciudad", query = "SELECT v FROM ViewModifyUser v WHERE v.idciudad = :idciudad"),
	@NamedQuery(name = "ViewModifyUser.findByIddepartamento", query = "SELECT v FROM ViewModifyUser v WHERE v.iddepartamento = :iddepartamento")})
public class ViewModifyUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Numero_documento")
	private String numerodocumento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Id_interno")
	private String idinterno;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Numero_telefono")
	private String numerotelefono;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "correo")
	private String correo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_usuario")
	private String nombreusuario;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "cargo")
	private String cargo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Tipo_telefono")
	private String tipotelefono;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Tipo_documento")
	private String tipodocumento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Tipo_email")
	private String tipoemail;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Direccion")
	private String direccion;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Tipo_direccion")
	private String tipodireccion;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre_ciudad")
	private String nombreciudad;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre_departamento")
	private String nombredepartamento;
	@Basic(optional = false)
    @NotNull
    @Column(name = "Id_usuario")
	@Id
	private int idusuario;
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
    @Column(name = "Id_cargo")
	private int idcargo;
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

	public ViewModifyUser() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getIdinterno() {
		return idinterno;
	}

	public void setIdinterno(String idinterno) {
		this.idinterno = idinterno;
	}

	public String getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTipotelefono() {
		return tipotelefono;
	}

	public void setTipotelefono(String tipotelefono) {
		this.tipotelefono = tipotelefono;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getTipoemail() {
		return tipoemail;
	}

	public void setTipoemail(String tipoemail) {
		this.tipoemail = tipoemail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipodireccion() {
		return tipodireccion;
	}

	public void setTipodireccion(String tipodireccion) {
		this.tipodireccion = tipodireccion;
	}

	public String getNombreciudad() {
		return nombreciudad;
	}

	public void setNombreciudad(String nombreciudad) {
		this.nombreciudad = nombreciudad;
	}

	public String getNombredepartamento() {
		return nombredepartamento;
	}

	public void setNombredepartamento(String nombredepartamento) {
		this.nombredepartamento = nombredepartamento;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
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
	
}
