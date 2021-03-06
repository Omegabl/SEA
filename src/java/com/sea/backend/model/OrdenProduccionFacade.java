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
package com.sea.backend.model;

import com.sea.backend.entities.ObservacionesOrdenProduccion;
import com.sea.backend.entities.OrdenProduccion;
import com.sea.backend.entities.ProductoEspecificacion;
import com.sea.backend.entities.ViewReporteControlOp;
import com.sea.backend.entities.ViewReporteHistoricoVentas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Depurador
 */
@Stateless
public class OrdenProduccionFacade extends AbstractFacade<OrdenProduccion> implements OrdenProduccionFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public OrdenProduccionFacade() {
		super(OrdenProduccion.class);
	}

	@Override
	public List<ObservacionesOrdenProduccion> observacionesOP(OrdenProduccion op) {
		List<ObservacionesOrdenProduccion> observacionesOP;
		observacionesOP=em.createNamedQuery("ObservacionesOrdenProduccion.findByIdOrdenProduccion")
            .setParameter("tblOrdenProduccionIdOrdenProduccion", op)
            .getResultList();
		return observacionesOP;
	}
	
	@Override
	public List<ProductoEspecificacion> datosTabla(OrdenProduccion op) {
		List<ProductoEspecificacion> observacionesOP;
		observacionesOP=em.createNamedQuery("ProductoEspecificacion.findByTblOrdenProduccionIdOrdenProduccion")
            .setParameter("tblOrdenProduccionIdOrdenProduccion", op)
            .getResultList();
		return observacionesOP;
	}
	
	@Override
	public List<ViewReporteControlOp> ReporteControlOP(){
		List<ViewReporteControlOp> controlOP;
		controlOP=em.createNamedQuery("ViewReporteControlOp.findAll")
            .getResultList();
		return controlOP;
	}
	
	@Override
	public List<ViewReporteHistoricoVentas> ReporteHistoricoVentas(){
		List<ViewReporteHistoricoVentas> historicoVentas;
		historicoVentas=em.createNamedQuery("ViewReporteHistoricoVentas.findAll")
            .getResultList();
		return historicoVentas;
	}
	
	@Override
	public void rechazarOrden(int op) {
		String actualizacion ="UPDATE tbl_orden_produccion SET ESTADO ='Necesita corrección' WHERE ID_ORDEN_PRODUCCION=?1";
		Query query = em.createNativeQuery(actualizacion);
		query.setParameter(1, op);
		query.executeUpdate();
	}
	
	@Override
	public void aprobarOrden(int op) {
		String actualizacion ="UPDATE tbl_orden_produccion SET ESTADO ='En seguimiento' WHERE ID_ORDEN_PRODUCCION=?1";
		Query query = em.createNativeQuery(actualizacion);
		query.setParameter(1, op);
		query.executeUpdate();
	}

}
