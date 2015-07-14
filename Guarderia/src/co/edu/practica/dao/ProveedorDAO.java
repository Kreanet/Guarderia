package co.edu.practica.dao;

import org.springframework.stereotype.Repository;

import co.edu.practica.entities.Proveedor;
 

@Repository("ProveedorDAO")
 
public class ProveedorDAO extends JpaDAO<Proveedor> {
	  
	 public ProveedorDAO(){
	      super.setClazz(Proveedor.class );
	   }
	}
