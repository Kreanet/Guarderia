package co.edu.practica.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;

import co.edu.practica.entities.Producto;
import co.edu.practica.entities.Proveedor;
import co.edu.practica.services.ProductoService;
import co.edu.practica.services.ProveedorService;

@Controller
@ManagedBean(name = "productoController")
public class ProductoController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Spring User Service is injected...
	@ManagedProperty(value = "#{productoService}")
	private ProductoService productoService;

	@ManagedProperty(value = "#{proveedorService}")
	private ProveedorService proveedorService;

	private List<Producto> listaProductos;
	private List<Proveedor> listaProveedor;

	private Proveedor proveedor = new Proveedor();
	private Producto producto = new Producto();

	private Long operador;
	private Long resultado;

	// constructor para actulizar cantidad

	public void dosuma() {

		Proveedor cnit = proveedorService.consultar(proveedor.getNit());
		producto.setProveedor(cnit);

		resultado = producto.getCantidad() + operador;
		producto.setCantidad(resultado);

		productoService.actualizar(producto);

	}

	public void doresta() {

		Proveedor cnit = proveedorService.consultar(proveedor.getNit());
		producto.setProveedor(cnit);

		resultado = producto.getCantidad() - operador;
		producto.setCantidad(resultado);

		productoService.actualizar(producto);

	}

	public Long getOperador() {
		return operador;
	}

	public void setOperador(Long operador) {
		this.operador = operador;
	}

	public Long getResultado() {
		return resultado;
	}

	public void setResultado(Long resultado) {
		this.resultado = resultado;
	}

	public ProveedorService getProveedorService() {
		return proveedorService;
	}

	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	public List<Proveedor> getListaProveedor() {
		listaProveedor = proveedorService.listProveedor();

		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@InitBinder
	public void initBinder() {

		if (listaProveedor != null)
			System.err.println("listaProveedor" + listaProveedor.size());
		else
			System.err.println("listaProveedor null");

	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public List<Producto> getListaProductos() {
		listaProductos = new ArrayList<Producto>();

		listaProductos.addAll(productoService.listProducto());

		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void eliminarProducto(ActionEvent event) {
		Long idProducto = (Long) event.getComponent().getAttributes().get("ideproducto");
		productoService.eliminar(idProducto);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Exito", "El producto se ha eliminado satisfactoriamente"));

	}

	public void actualizar(ActionEvent event) {

		Proveedor cnit = proveedorService.consultar(proveedor.getNit());
		producto.setProveedor(cnit);
		productoService.actualizar(producto);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Actualizado con exito..."));

	}

	public void guardarProducto(ActionEvent event) {

		Proveedor cnit = proveedorService.consultar(proveedor.getNit());
		producto.setProveedor(cnit);
		productoService.guardar(producto);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Insertado con exito..."));

	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}