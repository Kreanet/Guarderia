package co.edu.practica.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.edu.practica.entities.Usuario;
import co.edu.practica.services.UsuarioService;

@Controller
@ManagedBean(name = "usuarioController")
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Spring User Service is injected...
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	private List<Usuario> listaUsuarios;
	private Usuario usu = new Usuario();
	private String nombres = null;
	private String apellidos = null;
	private Long cedula = null;
	private String usuario = null;
	private String clave = null;
	private Long estado = null;
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public List<Usuario> getListaUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();

		listaUsuarios.addAll(usuarioService.listUsuario());
		return listaUsuarios;
		
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public Usuario getUsu() {
		return usu;
	}
	public void setUsu(Usuario usu) {
		this.usu = usu;
	}
	
	public void eliminarUsuario(ActionEvent event) {
		Long cedula = (Long) event.getComponent().getAttributes().get("cedula");
		usuarioService.eliminar(cedula);
	}
	
	public void actualizar(ActionEvent event) {

		usuarioService.guardar(usu);
		
	}

	public void guardarUsuario(ActionEvent event) {

		Usuario p= new Usuario();
		p.setNombres(nombres);
		p.setApellidos(apellidos);
		p.setCedula(cedula);
		p.setUsuario(usuario);
		p.setClave(clave);
		p.setEstado(estado);
		usuarioService.guardar(p);
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
