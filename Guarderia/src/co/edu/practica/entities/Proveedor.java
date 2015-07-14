package co.edu.practica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name = "proveedor")
@NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long Nit;

	private String contacto;

	private String correo;

	private String nombre;

	private String telefono;

	// bi-directional many-to-one association to Producto
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER)
	private List<Producto> productos;

	public Proveedor() {
	}

	public long getNit() {
		return Nit;
	}

	public void setNit(long nit) {
		Nit = nit;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProveedor(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProveedor(null);

		return producto;
	}

}