package co.edu.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.practica.dao.UsuarioDAO;
import co.edu.practica.entities.Usuario;

@Service
public class UsuarioService {
	 @Autowired
	    private UsuarioDAO usuarioDao;
	     
	    @Transactional
	    public void addUsuario(Usuario usuario) {
	    	usuarioDao.save(usuario);
	    }
	 
	    @Transactional
	    public List<Usuario> listUsuario() {
	 
	        return usuarioDao.findAll();
	    }
	    @Transactional
	    public void eliminar(Long cedula) {
	    	Usuario usuarioC=usuarioDao.findOne(cedula);
	    	if(usuarioC!=null)
	         usuarioDao.delete(usuarioC);
	    }
	  
	    @Transactional
	    public void guardar(Usuario usuario) {
	    	Usuario usuarioC=usuarioDao.findOne(usuario.getCedula());
	    	if(usuarioC==null){
	         usuarioDao.save(usuario);
	    	}else{
	         usuarioDao.update(usuario);
	    		
	    	}
	    }
	    
	    @Transactional
	    public Usuario consultar(Long cedula) {
	    	Usuario usuarioC=usuarioDao.findOne(cedula);
	    	return usuarioC;
	         
	    	
	    }
}
