package co.edu.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.practica.dao.ProveedorDAO;

import co.edu.practica.entities.Proveedor;

@Service
public class ProveedorService {

	@Autowired
	private ProveedorDAO proveedorDao;

	@Transactional
	public void addProveedor(Proveedor proveedor) {
		proveedorDao.save(proveedor);
	}

	@Transactional
	public List<Proveedor> listProveedor() {

		return proveedorDao.findAll();
	}

	@Transactional
	public void eliminar(Long Nit) {
		Proveedor proveedorC = proveedorDao.findOne(Nit);
		if (proveedorC != null)
			proveedorDao.delete(proveedorC);
	}

	@Transactional
	public void guardar(Proveedor proveedor) {
		Proveedor proveedorC = proveedorDao.findOne(proveedor.getNit());
		if (proveedorC == null) {
			proveedorDao.save(proveedor);
		} else {
			proveedorDao.update(proveedor);

		}
	}

	@Transactional
	public Proveedor consultar(Long Nit) {
		Proveedor proveedorC = proveedorDao.findOne(Nit);
		return proveedorC;

	}

}