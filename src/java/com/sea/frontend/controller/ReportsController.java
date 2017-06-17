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
package com.sea.frontend.controller;

import com.sea.backend.model.OrdenProduccionFacadeLocal;
import com.sea.backend.model.ProductoFacadeLocal;
import com.sea.backend.entities.ViewReporteControlOp;
import com.sea.backend.entities.ViewReporteHistoricoVentas;
import com.sea.backend.entities.ViewReporteListaPrecios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONObject;

/**
 *
 * @author Depurador
 */
@Named
@ViewScoped
public class ReportsController implements Serializable {

	//Variables de los dialogos y snackbars
	JSONObject dialogData = new JSONObject();
	JSONObject snackbarData = new JSONObject();

	private List<ViewReporteControlOp> reporteControlOP;
	private List<ViewReporteHistoricoVentas> ReporteHistoricoVentas;
	private List<ViewReporteListaPrecios> ReporteListaPrecios;

	@EJB
	private OrdenProduccionFacadeLocal ordenProduccionEJB;
	@EJB
	private ProductoFacadeLocal productoEJB;

	@PostConstruct
	public void init() {
		reporteControlOP = ordenProduccionEJB.ReporteControlOP();
		ReporteHistoricoVentas = ordenProduccionEJB.ReporteHistoricoVentas();
		ReporteListaPrecios = productoEJB.ReporteListaPrecios();
	}

	public void generarReporteControlOP() {
		try {
			reporteControlOP = ordenProduccionEJB.ReporteControlOP();
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}

	public void generarReporteHistoricoVentas() {
		try {
			ReporteHistoricoVentas = ordenProduccionEJB.ReporteHistoricoVentas();
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}
	
	public void generarReporteListaPrecios(){
		try {
			ReporteListaPrecios = productoEJB.ReporteListaPrecios();
		} catch (Exception e) {
			dialogData.put("titulo", "Error no controlado");
			dialogData.put("mensaje", e.getStackTrace());
			RequestContext.getCurrentInstance().execute("mostrarDialogos(" + dialogData + ");");
		}
	}

	//Getters & Setters
	public List<ViewReporteControlOp> getReporteControlOP() {
		return reporteControlOP;
	}

	public void setReporteControlOP(List<ViewReporteControlOp> reporteControlOP) {
		this.reporteControlOP = reporteControlOP;
	}

	public List<ViewReporteHistoricoVentas> getReporteHistoricoVentas() {
		return ReporteHistoricoVentas;
	}

	public void setReporteHistoricoVentas(List<ViewReporteHistoricoVentas> ReporteHistoricoVentas) {
		this.ReporteHistoricoVentas = ReporteHistoricoVentas;
	}

	public List<ViewReporteListaPrecios> getReporteListaPrecios() {
		return ReporteListaPrecios;
	}

	public void setReporteListaPrecios(List<ViewReporteListaPrecios> ReporteListaPrecios) {
		this.ReporteListaPrecios = ReporteListaPrecios;
	}

}
