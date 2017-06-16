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
@Table(name = "view_reporte_historico_ventas")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ViewReporteHistoricoVentas.findAll", query = "SELECT v FROM ViewReporteHistoricoVentas v"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByIdUsuario", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.idUsuario = :idUsuario"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByCliente", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.cliente = :cliente"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByDocumento", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.documento = :documento"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByFechaEnvioOc", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.fechaEnvioOc = :fechaEnvioOc"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByNumeroOp", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.numeroOp = :numeroOp"),
	@NamedQuery(name = "ViewReporteHistoricoVentas.findByFechaEntregaFinal", query = "SELECT v FROM ViewReporteHistoricoVentas v WHERE v.fechaEntregaFinal = :fechaEntregaFinal")})
public class ViewReporteHistoricoVentas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
	@Id
	private int idUsuario;
	@Size(max = 129)
    @Column(name = "cliente")
	private String cliente;
	@Size(max = 97)
    @Column(name = "documento")
	private String documento;
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio_oc")
    @Temporal(TemporalType.DATE)
	private Date fechaEnvioOc;
	@Basic(optional = false)
    @NotNull
    @Column(name = "numero_op")
	private int numeroOp;
	@Column(name = "fecha_entrega_final")
    @Temporal(TemporalType.DATE)
	private Date fechaEntregaFinal;

	public ViewReporteHistoricoVentas() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaEnvioOc() {
		return fechaEnvioOc;
	}

	public void setFechaEnvioOc(Date fechaEnvioOc) {
		this.fechaEnvioOc = fechaEnvioOc;
	}

	public int getNumeroOp() {
		return numeroOp;
	}

	public void setNumeroOp(int numeroOp) {
		this.numeroOp = numeroOp;
	}

	public Date getFechaEntregaFinal() {
		return fechaEntregaFinal;
	}

	public void setFechaEntregaFinal(Date fechaEntregaFinal) {
		this.fechaEntregaFinal = fechaEntregaFinal;
	}
	
}
