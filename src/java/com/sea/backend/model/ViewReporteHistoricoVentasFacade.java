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
package com.sea.backend.model;

import com.sea.backend.entities.ViewReporteHistoricoVentas;
import com.sea.backend.entities.ViewReporteSeguimientoGestionComercial;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EdisonArturo
 */
@Stateless
public class ViewReporteHistoricoVentasFacade extends AbstractFacade<ViewReporteHistoricoVentas> implements ViewReporteHistoricoVentasFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ViewReporteHistoricoVentasFacade() {
		super(ViewReporteHistoricoVentas.class);
	}
	
	@Override
	public List<ViewReporteHistoricoVentas> filterVentas(Date fecha1, Date fecha2, int idUsuario, String Cliente) {
		List<ViewReporteHistoricoVentas> observacionesOP;
		observacionesOP=em.createNamedQuery("ViewReporteHistoricoVentas.findByFilter")
            .setParameter("fecha1", fecha1).setParameter("fecha2", fecha2).setParameter("cliente", Cliente).setParameter("idUsuario", idUsuario)
            .getResultList();
		return observacionesOP;
	}
	
}
