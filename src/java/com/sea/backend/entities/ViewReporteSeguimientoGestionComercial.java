/*
 * The MIT License
 *
 * Copyright 2017 Depurador.
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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Depurador
 */
@Entity
@Table(name = "view_reporte_seguimiento_gestion_comercial")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findAll", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByFechaEmision", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.fechaEmision = :fechaEmision")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByNumeroCotizacion", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.numeroCotizacion = :numeroCotizacion")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByOrigen", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.origen = :origen")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByEmpresa", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.empresa = :empresa")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByDocumento", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.documento = :documento")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByTelefonoContacto", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.telefonoContacto = :telefonoContacto")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByNombreContacto", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.nombreContacto = :nombreContacto")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByEmailContacto", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.emailContacto = :emailContacto")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByDireccion", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.direccion = :direccion")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByVisita", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.visita = :visita")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByPrestamoMuestra", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.prestamoMuestra = :prestamoMuestra")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByNumeroRemision", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.numeroRemision = :numeroRemision")
	, @NamedQuery(name = "ViewReporteSeguimientoGestionComercial.findByFechaCierreEfectivo", query = "SELECT v FROM ViewReporteSeguimientoGestionComercial v WHERE v.fechaCierreEfectivo = :fechaCierreEfectivo")})
public class ViewReporteSeguimientoGestionComercial implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
	private Date fechaEmision;
	@Lob
    @Size(max = 65535)
    @Column(name = "ejecutivo")
	private String ejecutivo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "numero_cotizacion")
	@Id
	private String numeroCotizacion;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "origen")
	private String origen;
	@Size(max = 129)
    @Column(name = "empresa")
	private String empresa;
	@Size(max = 97)
    @Column(name = "documento")
	private String documento;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "telefono_contacto")
	private String telefonoContacto;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombre_contacto")
	private String nombreContacto;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email_contacto")
	private String emailContacto;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "direccion")
	private String direccion;
	@Column(name = "visita")
	private Boolean visita;
	@Column(name = "prestamo_muestra")
	private Boolean prestamoMuestra;
	@Size(max = 16)
    @Column(name = "numero_remision")
	private String numeroRemision;
	@Column(name = "fecha_cierre_efectivo")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierreEfectivo;

	public ViewReporteSeguimientoGestionComercial() {
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getVisita() {
		return visita;
	}

	public void setVisita(Boolean visita) {
		this.visita = visita;
	}

	public Boolean getPrestamoMuestra() {
		return prestamoMuestra;
	}

	public void setPrestamoMuestra(Boolean prestamoMuestra) {
		this.prestamoMuestra = prestamoMuestra;
	}

	public String getNumeroRemision() {
		return numeroRemision;
	}

	public void setNumeroRemision(String numeroRemision) {
		this.numeroRemision = numeroRemision;
	}

	public Date getFechaCierreEfectivo() {
		return fechaCierreEfectivo;
	}

	public void setFechaCierreEfectivo(Date fechaCierreEfectivo) {
		this.fechaCierreEfectivo = fechaCierreEfectivo;
	}
	
}
