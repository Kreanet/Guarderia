package co.edu.practica.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ideproducto;

	private long cantidad;

	private String desproducto;

	private long estado;

	private String ubicacion;

	private long valor;

	// bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name = "Nit")
	private Proveedor proveedor;

	public Producto() {
	}

	public long getIdeproducto() {
		return ideproducto;
	}

	public void setIdeproducto(long ideproducto) {
		this.ideproducto = ideproducto;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public String getDesproducto() {
		return desproducto;
	}

	public void setDesproducto(String desproducto) {
		this.desproducto = desproducto;
	}

	public long getEstado() {
		return estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}