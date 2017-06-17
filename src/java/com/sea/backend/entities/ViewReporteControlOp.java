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
 * @author EdisonArturo
 */
@Entity
@Table(name = "view_reporte_control_op")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ViewReporteControlOp.findAll", query = "SELECT v FROM ViewReporteControlOp v"),
	@NamedQuery(name = "ViewReporteControlOp.findFilter", query = "SELECT v FROM ViewReporteControlOp v WHERE v.asesor = :asesor AND v.cliente = :cliente AND v.estado = :estado"),
	@NamedQuery(name = "ViewReporteControlOp.findByCliente", query = "SELECT v FROM ViewReporteControlOp v WHERE v.cliente = :cliente"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaOc", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaOc = :fechaOc"),
	@NamedQuery(name = "ViewReporteControlOp.findByNumeroOp", query = "SELECT v FROM ViewReporteControlOp v WHERE v.numeroOp = :numeroOp"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaEnvioOp", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaEnvioOp = :fechaEnvioOp"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaEntrega1", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaEntrega1 = :fechaEntrega1"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaEntrega2", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaEntrega2 = :fechaEntrega2"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaEntregaFinal", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaEntregaFinal = :fechaEntregaFinal"),
	@NamedQuery(name = "ViewReporteControlOp.findByFechaFacturacion", query = "SELECT v FROM ViewReporteControlOp v WHERE v.fechaFacturacion = :fechaFacturacion"),
	@NamedQuery(name = "ViewReporteControlOp.findByEstado", query = "SELECT v FROM ViewReporteControlOp v WHERE v.estado = :estado")})
public class ViewReporteControlOp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Lob
    @Size(max = 65535)
    @Column(name = "asesor")
	@Id
	private String asesor;
	@Size(max = 129)
    @Column(name = "cliente")
	private String cliente;
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_oc")
    @Temporal(TemporalType.DATE)
	private Date fechaOc;
	@Basic(optional = false)
    @NotNull
    @Column(name = "numero_op")
	private int numeroOp;
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio_op")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioOp;
	@Column(name = "fecha_entrega_1")
    @Temporal(TemporalType.DATE)
	private Date fechaEntrega1;
	@Column(name = "fecha_entrega_2")
    @Temporal(TemporalType.DATE)
	private Date fechaEntrega2;
	@Column(name = "fecha_entrega_final")
    @Temporal(TemporalType.DATE)
	private Date fechaEntregaFinal;
	@Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaFacturacion;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "estado")
	private String estado;

	public ViewReporteControlOp() {
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getFechaOc() {
		return fechaOc;
	}

	public void setFechaOc(Date fechaOc) {
		this.fechaOc = fechaOc;
	}

	public int getNumeroOp() {
		return numeroOp;
	}

	public void setNumeroOp(int numeroOp) {
		this.numeroOp = numeroOp;
	}

	public Date getFechaEnvioOp() {
		return fechaEnvioOp;
	}

	public void setFechaEnvioOp(Date fechaEnvioOp) {
		this.fechaEnvioOp = fechaEnvioOp;
	}

	public Date getFechaEntrega1() {
		return fechaEntrega1;
	}

	public void setFechaEntrega1(Date fechaEntrega1) {
		this.fechaEntrega1 = fechaEntrega1;
	}

	public Date getFechaEntrega2() {
		return fechaEntrega2;
	}

	public void setFechaEntrega2(Date fechaEntrega2) {
		this.fechaEntrega2 = fechaEntrega2;
	}

	public Date getFechaEntregaFinal() {
		return fechaEntregaFinal;
	}

	public void setFechaEntregaFinal(Date fechaEntregaFinal) {
		this.fechaEntregaFinal = fechaEntregaFinal;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
