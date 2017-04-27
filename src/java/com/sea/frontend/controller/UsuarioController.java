/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sea.frontend.controller;

import com.sea.backend.entities.Cargo;
import com.sea.backend.entities.CargoPerfil;
import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Departamento;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.Email;
import com.sea.backend.entities.Perfil;
import com.sea.backend.entities.Telefono;
import com.sea.backend.entities.TipoDireccion;
import com.sea.backend.entities.TipoDocumento;
import com.sea.backend.entities.TipoEmail;
import com.sea.backend.entities.TipoTelefono;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.CargoFacadeLocal;
import com.sea.backend.model.CargoPerfilFacadeLocal;
import com.sea.backend.model.CiudadFacadeLocal;
import com.sea.backend.model.DepartamentoFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
import com.sea.backend.model.EmailFacadeLocal;
import com.sea.backend.model.PerfilFacadeLocal;
import com.sea.backend.model.TelefonoFacadeLocal;
import com.sea.backend.model.TipoDireccionFacadeLocal;
import com.sea.backend.model.TipoDocumentoFacadeLocal;
import com.sea.backend.model.TipoEmailFacadeLocal;
import com.sea.backend.model.TipoTelefonoFacadeLocal;
import com.sea.backend.model.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import static jdk.nashorn.internal.runtime.ListAdapter.create;

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

	@EJB
	private UsuarioFacadeLocal usuarioEJB;

	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private List<Usuario> lista;
	private String accion;
	private String limpieza = "";

	@EJB
	private TelefonoFacadeLocal telefonoEJB;
	private Telefono telefono;

	@EJB
	private TipoTelefonoFacadeLocal tipoTelefonoEJB;
	private TipoTelefono tipoTelefono;

	@EJB
	private TipoEmailFacadeLocal tipoEmailEJB;
	private TipoEmail tipoEmail;

	@EJB
	private TipoDireccionFacadeLocal tipoDireccionEJB;
	private TipoDireccion tipoDireccion;

	@EJB
	private EmailFacadeLocal correoEJB;
	private Email correo;
	
	@EJB
	private CargoFacadeLocal CargoEJB;
	private Cargo cargo;
	private List<Cargo> listaCargos;

	@EJB
	private CargoPerfilFacadeLocal cargoPerfilEJB;
	private CargoPerfil cargoPerfil;

	@EJB
	private PerfilFacadeLocal perfilEJB;
	private Perfil perfilt;

	@EJB
	private DireccionFacadeLocal direccionEJB;
	private Direccion direccion;
	
	@EJB
	private DepartamentoFacadeLocal departamentoEJB;
	private Departamento departamento;
	
	@EJB
	private CiudadFacadeLocal ciudadEJB;
	private Ciudad ciudad;
	private List<Ciudad> ciudades;

	@EJB
	private TipoDocumentoFacadeLocal tipoDocumentoEJB;
	private TipoDocumento tipoDocumento;


	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Email getCorreo() {
		return correo;
	}

	public void setCorreo(Email correo) {
		this.correo = correo;
	}

	public String getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(String limpieza) {
		this.limpieza = limpieza;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<Usuario> getListaUsuarios() {
		listaUsuarios = usuarioEJB.findAll();
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		telefono = new Telefono();
		correo = new Email();
		perfilt = new Perfil();
		lista = usuarioEJB.listaUsuario();
		direccion = new Direccion();
		tipoTelefono = new TipoTelefono();
		tipoDireccion = new TipoDireccion();
		tipoEmail = new TipoEmail();
		tipoDocumento = new TipoDocumento();
		departamento = new Departamento();
		ciudad = new Ciudad();
		ciudades = ciudadEJB.findAll();
		cargo = new Cargo();
		listaCargos = CargoEJB.findAll();
		cargoPerfil = new CargoPerfil();
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Perfil getPerfilt() {
		return perfilt;
	}

	public void setPerfilt(Perfil perfilt) {
		this.perfilt = perfilt;
	}

	public void registrar() {
		try {
			usuario.setTblTipoDocumentoIdTipoDocumento(tipoDocumentoEJB.find(tipoDocumento.getIdTipoDocumento()));
			usuario.setTblCargoIdCargo(cargo);
			usuarioEJB.create(usuario);
			telefono.setTblTipoTelefonoIdTipoTelefono(tipoTelefonoEJB.find(tipoTelefono.getIdTipoTelefono()));
			telefono.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			telefonoEJB.create(telefono);
			correo.setTblTipoEmailIdTipoEmail(tipoEmailEJB.find(tipoEmail.getIdTipoEmail()));
			correo.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			correoEJB.create(correo);
			direccion.setTblTipoDireccionIdTipoDireccion(tipoDireccionEJB.find(tipoDireccion.getIdTipoDireccion()));
			direccion.setTblUsuarioIdUsuario(usuarioEJB.find(usuario.getIdUsuario()));
			direccion.setTblCiudadIdCiudad(ciudadEJB.listaCiudad(ciudad.getNombre()));
			direccionEJB.create(direccion);
		} catch (Exception e) {

		}
		lista = usuarioEJB.listaUsuario();
	}
	
	
	public void obtenerCiudad() {
		ciudades = ciudadEJB.listaCiudades(departamento);

	}

	public void modificar() {
		try {
			getAccion();
			usuarioEJB.edit(usuario);
		} catch (Exception e) {

		}

	}

	public void eliminar(Usuario usuario) {
		try {
			getAccion();
			usuarioEJB.remove(usuario);
		} catch (Exception e) {

		}

	}

	public void lista() {
		lista = usuarioEJB.listaUsuario();
	}

	public void leerID(int usuario) throws Exception {
		this.usuario = usuarioEJB.find(usuario);
		this.direccion = usuarioEJB.actualizarCiudad(usuarioEJB.find(usuario));
		setAccion("Modificar");
	}

	public void limpiar() {
		usuario.setNumeroDocumento(limpieza);
		usuario.setNombre(limpieza);
		usuario.setApellido(limpieza);
		telefono.setNumeroTelefono(limpieza);
		direccion.setDireccion(limpieza);

	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public CargoPerfil getCargoPerfil() {
		return cargoPerfil;
	}

	public void setCargoPerfil(CargoPerfil cargoPerfil) {
		this.cargoPerfil = cargoPerfil;
	}

	


	
	
	

}
