package co.edu.practica.dao;

import org.springframework.stereotype.Repository;

import co.edu.practica.entities.Usuario;
 
@Repository("UsuarioDAO")

public class UsuarioDAO extends JpaDAO<Usuario>{

	public UsuarioDAO() {
	      super.setClazz(Usuario.class );
	   }
}
