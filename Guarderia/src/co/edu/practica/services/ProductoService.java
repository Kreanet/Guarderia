package co.edu.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.practica.dao.ProductoDAO;
import co.edu.practica.entities.Producto;

@Service
public class ProductoService {

	@Autowired
	private ProductoDAO productoDao;

	@Transactional
	public void addProducto(Producto producto) {
		productoDao.save(producto);
	}

	@Transactional
	public List<Producto> listProducto() {

		return productoDao.findAll();
	}

	@Transactional
	public void eliminar(Long idProducto) {
		Producto productoC = productoDao.findOne(idProducto);
		if (productoC != null)
			productoDao.delete(productoC);
	}

	@Transactional
	public void guardar(Producto producto) {
		// Producto productoC=productoDao.findOne(producto.getIdeproducto());
		// if(productoC==null){
		productoDao.save(producto);
		// }else{
		// productoDao.update(producto);

		// }
	}

	@Transactional
	public void actualizar(Producto producto) {
		Producto productoC = productoDao.findOne(producto.getIdeproducto());
		if (productoC == null) {
			productoDao.save(producto);
		} else {
	productoDao.update(producto);

		}
	}

	@Transactional
	public Producto consultar(Long idProducto) {
		Producto productoC = productoDao.findOne(idProducto);
		return productoC;

	}

}