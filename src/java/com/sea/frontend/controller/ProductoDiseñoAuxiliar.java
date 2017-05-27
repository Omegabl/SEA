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

import java.util.Date;

/**
 *
 * @author EdisonArturo
 */
public class ProductoDiseñoAuxiliar {
	private Integer idProducto;
	private String referencia;
	private String descripcion;
	private Date fechaActualizacion;
	private float precio;
	private Boolean personalizado;
	private Integer idDisenoProducto;
	private String logotipo;
	private String diagramaDiseno;
	private Boolean necesitaBordado;
	private String diseno;
	private String descripcionDiseno;
	private Integer idTalla;
	private String talla;
	private String idTallaDisenoProducto;
	private String cantidad;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Boolean getPersonalizado() {
		return personalizado;
	}

	public void setPersonalizado(Boolean personalizado) {
		this.personalizado = personalizado;
	}

	public Integer getIdDisenoProducto() {
		return idDisenoProducto;
	}

	public void setIdDisenoProducto(Integer idDisenoProducto) {
		this.idDisenoProducto = idDisenoProducto;
	}

	public String getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}

	public String getDiagramaDiseno() {
		return diagramaDiseno;
	}

	public void setDiagramaDiseno(String diagramaDiseno) {
		this.diagramaDiseno = diagramaDiseno;
	}

	public Boolean getNecesitaBordado() {
		return necesitaBordado;
	}

	public void setNecesitaBordado(Boolean necesitaBordado) {
		this.necesitaBordado = necesitaBordado;
	}

	public String getDiseno() {
		return diseno;
	}

	public void setDiseno(String diseno) {
		this.diseno = diseno;
	}

	public String getDescripcionDiseno() {
		return descripcionDiseno;
	}

	public void setDescripcionDiseno(String descripcionDiseno) {
		this.descripcionDiseno = descripcionDiseno;
	}

	public Integer getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(Integer idTalla) {
		this.idTalla = idTalla;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getIdTallaDisenoProducto() {
		return idTallaDisenoProducto;
	}

	public void setIdTallaDisenoProducto(String idTallaDisenoProducto) {
		this.idTallaDisenoProducto = idTallaDisenoProducto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	

	public ProductoDiseñoAuxiliar(Integer idProducto, String referencia, String descripcion, Date fechaActualizacion, float precio, Boolean personalizado, Integer idDisenoProducto, String logotipo,
	 String diagramaDiseno, Boolean necesitaBordado, String diseno, String descripcionDiseno, Integer idTalla, String talla, String idTallaDisenoProducto, String cantidad) {
		this.idProducto = idProducto;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.fechaActualizacion = fechaActualizacion;
		this.precio = precio;
		this.personalizado = personalizado;
		this.idDisenoProducto = idDisenoProducto;
		this.logotipo = logotipo;
		this.diagramaDiseno = diagramaDiseno;
		this.necesitaBordado = necesitaBordado;
		this.diseno = diseno;
		this.descripcionDiseno = descripcionDiseno;
		this.idTalla = idTalla; 
		this.talla = talla;
		this.idTallaDisenoProducto = idTallaDisenoProducto;
		this.cantidad = cantidad;
		
	}

	
        public ProductoDiseñoAuxiliar(){
		
		}
}
