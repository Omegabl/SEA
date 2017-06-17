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

import com.sea.backend.entities.ViewReporteSeguimientoGestionComercial;
import com.sea.backend.model.ViewReporteSeguimientoGestionComercialFacadeLocal;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named
@ViewScoped
public class seguimientoComercialController implements Serializable {

	@EJB
	private ViewReporteSeguimientoGestionComercialFacadeLocal seguimientoEJB;
	private ViewReporteSeguimientoGestionComercial seguimiento;
	private List<ViewReporteSeguimientoGestionComercial> listaSeguimiento;
	private List<Object[]> listaReporte;
	private List<Object[]> listaReporte2;
	private Date fecha1;
	private Date fecha2;
	private CartesianChartModel combinedModel;

	@PostConstruct
	public void init() {
		seguimientoEJB.leguaje();
		listaSeguimiento = seguimientoEJB.findAll();
		listaReporte = seguimientoEJB.listaReporte();
		listaReporte2 = seguimientoEJB.listaReporte2();
		createCombinedModel();
	}

	public void filtrar() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
		listaReporte = seguimientoEJB.filtroListaReporte(dateFormat.format(fecha1), dateFormat.format(fecha2));
		listaReporte2 = seguimientoEJB.filtroListaReporte2(dateFormat.format(fecha1), dateFormat.format(fecha2));
		createCombinedModel();
		listaSeguimiento =  seguimientoEJB.observacionesOP(dateFormat.format(fecha1), dateFormat.format(fecha2));
	}
	
	public void descargarReporte(){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
			String ruta = servletContext.getRealPath("/reportes/SeguimientoComercial.jasper");
			seguimientoEJB.getReporteSeguimiento(ruta, dateFormat.format(fecha1), dateFormat.format(fecha2));
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(seguimientoComercialController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(seguimientoComercialController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(seguimientoComercialController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(seguimientoComercialController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void createCombinedModel() {
		combinedModel = new BarChartModel();

		BarChartSeries cotizaciones = new BarChartSeries();
		cotizaciones.setLabel("Cotizaciones totales");

		for (Object[] viewReporteSeguimientoGestionComercial : listaReporte) {
			cotizaciones.set(viewReporteSeguimientoGestionComercial[1], Integer.parseInt(viewReporteSeguimientoGestionComercial[0].toString()));
			System.out.println(viewReporteSeguimientoGestionComercial[1].toString() + viewReporteSeguimientoGestionComercial[0].toString());
		}

		LineChartSeries cotizacionesCerradas = new LineChartSeries();
		cotizacionesCerradas.setLabel("Cotizaciones aprobadas");
		for (Object[] viewReporteSeguimientoGestionComercial : listaReporte2) {
			cotizacionesCerradas.set(viewReporteSeguimientoGestionComercial[1], Integer.parseInt(viewReporteSeguimientoGestionComercial[0].toString()));
			System.out.println(viewReporteSeguimientoGestionComercial[1].toString() + viewReporteSeguimientoGestionComercial[0].toString());
		}

		combinedModel.addSeries(cotizaciones);
		combinedModel.addSeries(cotizacionesCerradas);

		combinedModel.setTitle("Cotizaciones");
		combinedModel.setLegendPosition("ne");
		combinedModel.setMouseoverHighlight(false);
		combinedModel.setShowDatatip(false);
		combinedModel.setShowPointLabels(true);
		Axis yAxis = combinedModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	public ViewReporteSeguimientoGestionComercial getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(ViewReporteSeguimientoGestionComercial seguimiento) {
		this.seguimiento = seguimiento;
	}

	public List<ViewReporteSeguimientoGestionComercial> getListaSeguimiento() {
		return listaSeguimiento;
	}

	public void setListaSeguimiento(List<ViewReporteSeguimientoGestionComercial> listaSeguimiento) {
		this.listaSeguimiento = listaSeguimiento;
	}

	public List<Object[]> getListaReporte() {
		return listaReporte;
	}

	public void setListaReporte(List<Object[]> listaReporte) {
		this.listaReporte = listaReporte;
	}

	public CartesianChartModel getCombinedModel() {
		return combinedModel;
	}

	public void setCombinedModel(CartesianChartModel combinedModel) {
		this.combinedModel = combinedModel;
	}

	public List<Object[]> getListaReporte2() {
		return listaReporte2;
	}

	public void setListaReporte2(List<Object[]> listaReporte2) {
		this.listaReporte2 = listaReporte2;
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
