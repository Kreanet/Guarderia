package co.edu.practica.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private String usuario;
	private String clave;
	private boolean logueado = false;

	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String validar() {
		FacesMessage msg = null;
		if (usuario != null && usuario.equals("admin") && clave != null && clave.equals("admin")) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario);
			// FacesContext.getCurrentInstance().addMessage(null, msg);
			logueado = true;
			// return "caja";
		} else {
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
			// FacesContext.getCurrentInstance().addMessage(null, msg);
			logueado = false;
			// return "login";
		}
		if (logueado) {
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "TablaProductos";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login";
		}
	}

	public void logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		logueado = false;
	}
}