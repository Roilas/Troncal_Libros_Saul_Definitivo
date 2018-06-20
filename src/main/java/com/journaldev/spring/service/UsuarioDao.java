package com.journaldev.spring.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.journaldev.jpa.data.Libros;
import com.journaldev.jpa.data.Usuarios;

@Component
public class UsuarioDao {
	


	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Autowired
	private PlatformTransactionManager transactionManager;

	
	public String iniciarSesion(Usuarios usuario) {
		List<String> lstPass;
		
		String nombre = usuario.getNombre();
		String password = usuario.getPassword();
		
		lstPass = em.createNativeQuery("SELECT password FROM Usuarios WHERE nombre='" + nombre + "'").getResultList();
		if (lstPass.contains(password)) {
//			System.out.print("sdfgdgdfg");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario); 
			return "index";	
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Contraseña incorrecta"));
			return "";
		}
	}
	
	

	
	public String irRegistrar() {
		return "register";
	}
	
	@Transactional
	public String registrar(Usuarios usuario) {
		List<String> lstUsuarios;
		
		lstUsuarios = em.createNativeQuery("SELECT nombre FROM Usuarios").getResultList();
		
		if (lstUsuarios.contains(usuario.getNombre()) == false) {
			this.em.persist(usuario);
			return "login";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Ese nombre de usuario ya existe"));
			return "";
		}
		
	}
	

}
