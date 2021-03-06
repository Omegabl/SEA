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

import com.sea.backend.entities.ViewReporteSeguimientoGestionComercial;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author EdisonArturo
 */
@Stateless
public class ViewReporteSeguimientoGestionComercialFacade extends AbstractFacade<ViewReporteSeguimientoGestionComercial> implements ViewReporteSeguimientoGestionComercialFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ViewReporteSeguimientoGestionComercialFacade() {
		super(ViewReporteSeguimientoGestionComercial.class);
	}

	@Override
	public void leguaje() {
		List<Object[]> listaReporte;

		String consulta = "SET lc_time_names = 'es_MX';";
		Query query = em.createNativeQuery(consulta);
		query.executeUpdate();
	}

	@Override
	public List<Object[]> listaReporte() {
		List<Object[]> listaReporte;

		String consulta = "select count(numero_cotizacion), MONTHname(fecha_emision) as fecha from tbl_cotizacion\n"
				+ "group by fecha";
		Query query = em.createNativeQuery(consulta);

		listaReporte = query.getResultList();
		return listaReporte;
	}

	@Override
	public List<Object[]> listaReporte2() {
		List<Object[]> listaReporte;

		String consulta = "select count(numero_cotizacion), MONTHname(fecha_emision) as fecha from tbl_cotizacion\n"
				+ "        where estado=\"Cierre efectivo\"\n"
				+ "        group by fecha";
		Query query = em.createNativeQuery(consulta);

		listaReporte = query.getResultList();
		return listaReporte;
	}

	@Override
	public List<Object[]> filtroListaReporte(String fechaRango1, String fechaRango2) {
		List<Object[]> listaReporte;

		String consulta = "select count(numero_cotizacion), MONTHname(fecha_emision) as fecha from tbl_cotizacion\n"
				+ "where fecha_emision between ?1 and ?2 \n"
				+ "group by fecha";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, fechaRango1);
		query.setParameter(2, fechaRango2);

		listaReporte = query.getResultList();
		return listaReporte;
	}

	@Override
	public List<Object[]> filtroListaReporte2(String fechaRango1, String fechaRango2) {
		List<Object[]> listaReporte;

		String consulta = "select count(numero_cotizacion), MONTHname(fecha_emision) as fecha from tbl_cotizacion\n"
				+ "        where estado=\"Cierre efectivo\" and fecha_emision between ?1 and ?2 \n"
				+ "        group by fecha";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, fechaRango1);
		query.setParameter(2, fechaRango2);

		listaReporte = query.getResultList();
		return listaReporte;
	}
	
	@Override
	public List<ViewReporteSeguimientoGestionComercial> observacionesOP(String fecha1, String fecha2) {
		List<ViewReporteSeguimientoGestionComercial> observacionesOP;
		observacionesOP=em.createNamedQuery("ViewReporteSeguimientoGestionComercial.findByFechas")
            .setParameter("fecha1", fecha1).setParameter("fecha2", fecha2)
            .getResultList();
		return observacionesOP;
	}
	
	@Override
	public void getReporteSeguimiento(String ruta, String fecha1, String fecha2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection conexion;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulldotaciones", "root", "");

		//Se definen los parametros si es que el reporte necesita
		Map parameter = new HashMap();
		parameter.put("fecha1", fecha1);
		parameter.put("fecha2", fecha2);

		try {
			File file = new File(ruta);
			String destino = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\SEA\\web\\PDF/ReporteDeSeguimiento.pdf";

			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

			JasperExportManager.exportReportToPdfFile(jasperPrint, destino);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
