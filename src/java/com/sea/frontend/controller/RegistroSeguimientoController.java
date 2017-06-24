/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.RegistroSeguimiento;
import com.sea.backend.entities.CotizacionProducto;
import com.sea.backend.entities.DescuentoVolumen;
import com.sea.backend.entities.LugaresEntrega;
import com.sea.backend.entities.ModalidadDePago;
import com.sea.backend.entities.PropuestaNoIncluye;
import com.sea.backend.entities.TiempoEntrega;
import com.sea.backend.model.CotizacionFacadeLocal;
import com.sea.backend.model.RegistroSeguimientoFacadeLocal;
import com.sea.backend.model.CotizacionProductoFacadeLocal;
import com.sea.backend.model.DescuentoVolumenFacadeLocal;
import com.sea.backend.model.LugaresEntregaFacadeLocal;
import com.sea.backend.model.ModalidadDePagoFacadeLocal;
import com.sea.backend.model.PropuestaNoIncluyeFacadeLocal;
import com.sea.backend.model.TiempoEntregaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class RegistroSeguimientoController implements Serializable {

	@EJB
	private RegistroSeguimientoFacadeLocal registroSeguimientoEJB;
	@EJB
	private CotizacionProductoFacadeLocal cotizacionProductoEJB;
	@EJB
	private CotizacionFacadeLocal cotizacionEJB;

	//variables
	private RegistroSeguimiento registroSeguimiento;
	private Cotizacion cotizacion;
	private List<CotizacionProducto> listacotizacionProducto;
	private String numeroCotizacion;

	//EJB Propuesta no incluye
	@EJB
	private PropuestaNoIncluyeFacadeLocal propuestaEJB;
	private List<PropuestaNoIncluye> ListapropuestaNoIncluye;
	private int idPropuestaNoIncluye;
	private PropuestaNoIncluye propuestaNoIncluye;

	//Ejb de la foranea TiempoEntrega
	@EJB
	private TiempoEntregaFacadeLocal tiempoEJB;
	private int idTiempoEntrega;
	private TiempoEntrega tiempoEntrega;
	private List<TiempoEntrega> listaTiempoEntrega;

	//Ejb de la foranea DescuentoVolen
	@EJB
	private DescuentoVolumenFacadeLocal descuentoVEJB;
	private int idDescuentoVolumen;
	private DescuentoVolumen descuentoVolumen;
	private List<DescuentoVolumen> listaDescuentoVolumen;

	//EJB Modalidades de pago
	@EJB
	private ModalidadDePagoFacadeLocal modalidadPEJB;
	private int idModalidadDePago;
	private List<ModalidadDePago> listaModalidadDePago;
	private ModalidadDePago modalidadDePago;

	//EJB Lugares de entrega
	@EJB
	private LugaresEntregaFacadeLocal lugaresEEJB;
	private int idLugaresEntrega;
	private LugaresEntrega lugaresEntrega;
	private List<LugaresEntrega> listaLugaresEntrega;

	@PostConstruct
	public void init() {
		cotizacion = new Cotizacion();
		registroSeguimiento = new RegistroSeguimiento();
		/*cotizacionP = new CotizacionProducto();
		producto = new Producto();
		listaCotizacionP = new ArrayList<>();
		listaProducto = productoEJB.findAll();
		usuario = new Usuario();*/
		lugaresEntrega = new LugaresEntrega();
		tiempoEntrega = new TiempoEntrega();
		descuentoVolumen = new DescuentoVolumen();
		ListapropuestaNoIncluye = propuestaEJB.findAll();
		listaTiempoEntrega = tiempoEJB.findAll();
		listaLugaresEntrega = lugaresEEJB.findAll();
		listaDescuentoVolumen = descuentoVEJB.findAll();
		listaModalidadDePago = modalidadPEJB.findAll();
		propuestaNoIncluye = new PropuestaNoIncluye();
	}

	public void obtenerCotizacion() {
		try {
			cotizacion = cotizacionEJB.find(numeroCotizacion);
			listacotizacionProducto = cotizacionProductoEJB.productosCotizados(numeroCotizacion);
			idModalidadDePago = cotizacion.getTblModalidadDePagoIdModalidadDePago().getIdModalidadDePago();
			idLugaresEntrega = cotizacion.getTblLugaresEntregaIdLugaresEntrega().getIdLugaresEntrega();
			idDescuentoVolumen = cotizacion.getTblDescuentoVolumenIdDescuentoVolumen().getIdDescuentoVolumen();
			idTiempoEntrega = cotizacion.getTblTiempoEntregaIdTiempoEntrega().getIdTiempoEntrega();
			idPropuestaNoIncluye = cotizacion.getTblPropuestaNoIncluyeIdPropuestaNoIncluye().getIdPropuestaNoIncluye();
		} catch (Exception e) {
		}
	}

	//Getter & Setter
	public RegistroSeguimiento getRegistroSeguimiento() {
		return registroSeguimiento;
	}

	public void setRegistroSeguimiento(RegistroSeguimiento registroSeguimiento) {
		this.registroSeguimiento = registroSeguimiento;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public int getIdPropuestaNoIncluye() {
		return idPropuestaNoIncluye;
	}

	public void setIdPropuestaNoIncluye(int idPropuestaNoIncluye) {
		this.idPropuestaNoIncluye = idPropuestaNoIncluye;
	}

	public PropuestaNoIncluye getPropuestaNoIncluye() {
		return propuestaNoIncluye;
	}

	public void setPropuestaNoIncluye(PropuestaNoIncluye propuestaNoIncluye) {
		this.propuestaNoIncluye = propuestaNoIncluye;
	}

	public int getIdTiempoEntrega() {
		return idTiempoEntrega;
	}

	public void setIdTiempoEntrega(int idTiempoEntrega) {
		this.idTiempoEntrega = idTiempoEntrega;
	}

	public TiempoEntrega getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(TiempoEntrega tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public List<TiempoEntrega> getListaTiempoEntrega() {
		return listaTiempoEntrega;
	}

	public void setListaTiempoEntrega(List<TiempoEntrega> listaTiempoEntrega) {
		this.listaTiempoEntrega = listaTiempoEntrega;
	}

	public int getIdDescuentoVolumen() {
		return idDescuentoVolumen;
	}

	public void setIdDescuentoVolumen(int idDescuentoVolumen) {
		this.idDescuentoVolumen = idDescuentoVolumen;
	}

	public DescuentoVolumen getDescuentoVolumen() {
		return descuentoVolumen;
	}

	public void setDescuentoVolumen(DescuentoVolumen descuentoVolumen) {
		this.descuentoVolumen = descuentoVolumen;
	}

	public List<DescuentoVolumen> getListaDescuentoVolumen() {
		return listaDescuentoVolumen;
	}

	public void setListaDescuentoVolumen(List<DescuentoVolumen> listaDescuentoVolumen) {
		this.listaDescuentoVolumen = listaDescuentoVolumen;
	}

	public int getIdModalidadDePago() {
		return idModalidadDePago;
	}

	public void setIdModalidadDePago(int idModalidadDePago) {
		this.idModalidadDePago = idModalidadDePago;
	}

	public List<ModalidadDePago> getListaModalidadDePago() {
		return listaModalidadDePago;
	}

	public void setListaModalidadDePago(List<ModalidadDePago> listaModalidadDePago) {
		this.listaModalidadDePago = listaModalidadDePago;
	}

	public ModalidadDePago getModalidadDePago() {
		return modalidadDePago;
	}

	public void setModalidadDePago(ModalidadDePago modalidadDePago) {
		this.modalidadDePago = modalidadDePago;
	}

	public int getIdLugaresEntrega() {
		return idLugaresEntrega;
	}

	public void setIdLugaresEntrega(int idLugaresEntrega) {
		this.idLugaresEntrega = idLugaresEntrega;
	}

	public LugaresEntrega getLugaresEntrega() {
		return lugaresEntrega;
	}

	public void setLugaresEntrega(LugaresEntrega lugaresEntrega) {
		this.lugaresEntrega = lugaresEntrega;
	}

	public List<LugaresEntrega> getListaLugaresEntrega() {
		return listaLugaresEntrega;
	}

	public void setListaLugaresEntrega(List<LugaresEntrega> listaLugaresEntrega) {
		this.listaLugaresEntrega = listaLugaresEntrega;
	}

	public List<PropuestaNoIncluye> getListapropuestaNoIncluye() {
		return ListapropuestaNoIncluye;
	}

	public void setListapropuestaNoIncluye(List<PropuestaNoIncluye> ListapropuestaNoIncluye) {
		this.ListapropuestaNoIncluye = ListapropuestaNoIncluye;
	}

	public List<CotizacionProducto> getListacotizacionProducto() {
		return listacotizacionProducto;
	}

	public void setListacotizacionProducto(List<CotizacionProducto> listacotizacionProducto) {
		this.listacotizacionProducto = listacotizacionProducto;
	}

}
