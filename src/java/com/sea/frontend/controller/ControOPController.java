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

import com.sea.backend.entities.ViewReporteControlOp;
import com.sea.backend.model.ViewReporteControlOpFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ControOPController {
	@EJB
	private ViewReporteControlOpFacadeLocal reporteOPEJB;
	private ViewReporteControlOp reporteOP;
	private List<ViewReporteControlOp> listaReporteOP;
	
	@PostConstruct
	public void init(){
		listaReporteOP = reporteOPEJB.findAll();
		reporteOP = new ViewReporteControlOp();
	}
	
	public void filtroOP(){
		listaReporteOP = reporteOPEJB.filtroOP(reporteOP.getAsesor(), reporteOP.getCliente(), reporteOP.getEstado());
	}

	public ViewReporteControlOp getReporteOP() {
		return reporteOP;
	}

	public void setReporteOP(ViewReporteControlOp reporteOP) {
		this.reporteOP = reporteOP;
	}

	public List<ViewReporteControlOp> getListaReporteOP() {
		return listaReporteOP;
	}

	public void setListaReporteOP(List<ViewReporteControlOp> listaReporteOP) {
		this.listaReporteOP = listaReporteOP;
	}
}
