package co.edu.practica.dao;

import org.springframework.stereotype.Repository;

import co.edu.practica.entities.Producto;
 

@Repository("ProductoDAO")
 
public class ProductoDAO extends JpaDAO<Producto> {
	  
	 public ProductoDAO(){
	      super.setClazz(Producto.class );
	   }
	}
