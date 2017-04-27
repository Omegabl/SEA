package com.sea.frontend.controller;

import com.sea.backend.entities.Ciudad;
import com.sea.backend.entities.Cliente;
import com.sea.backend.entities.Departamento;
import com.sea.backend.entities.Direccion;
import com.sea.backend.entities.TipoDocumento;
import com.sea.backend.entities.TipoEmail;
import com.sea.backend.entities.TipoTelefono;
import com.sea.backend.entities.Usuario;
import com.sea.backend.model.ClienteFacadeLocal;
import com.sea.backend.model.DireccionFacadeLocal;
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

/**
 *
 * @author homero
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	
	@EJB
	private UsuarioFacadeLocal usuarioEJB;
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	@EJB
	private TipoTelefonoFacadeLocal tipoTelefonoEJB;
	private TipoTelefono tipoTelefono;
	private List<TipoTelefono> listaTipoTelefono;
	
	@EJB
	private TipoDocumentoFacadeLocal tipoDocumentoEJB;
	private TipoDocumento tipoDocumento;
	private List<TipoDocumento> listaTipoDocumento;
	
	@EJB
	private TipoEmailFacadeLocal tipoEmailEJB;
	private TipoEmail tipoEmail;
	private List<TipoEmail> listaTipoEmail;
	
	@EJB
	private DireccionFacadeLocal direccionEJB;
	private Direccion direccion;
	private List<Direccion> listaDireccion;
	
	private Ciudad ciudad;
	private List<Ciudad> listaCiudad;
	
	private Departamento departamento;
	private List<Departamento> listaDepartamento;


	@PostConstruct
	public void init() {
		cliente = new Cliente();
		listaClientes = clienteEJB.listaClientes();
		usuario = new Usuario();
		listaUsuario = usuarioEJB.findAll();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
