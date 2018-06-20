package com.TroncalLibrosSaul.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

import com.TroncalLibrosSaul.ClasesBasicas.Libro;

@Component
public class ServiciosLibros {
	
	
	
	public ServiciosLibros() {
		super();
	}





//	@PersistenceContext
//	private EntityManager em;
//
//	public EntityManager getEm() {
//		return em;
//	}
//
//	public void setEm(EntityManager em) {
//		this.em = em;
//	}
//
//	@Autowired
//    private PlatformTransactionManager transactionManager;
	
	public  void MuestraMensaje(){
		System.out.print("-------------------------------------");
		System.out.print("SERVICIOS LIBROS: mensaje de prueba");
	}
	
	
	
	
	
	@Transactional
	public void register(Libro emp){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ejemplojpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		try {
			System.out.print("-------------------------------------");
			System.out.print("SERVICIOS LIBROS: Comando Registrar");
			System.out.print("SERVICIOS LIBROS: Registrando el libro: " + emp.getTitulo() + " escrito por " + emp.getAutor());
			em.persist(emp);
			System.out.print("SERVICIOS LIBROS: Dato introducido con exito");
//			this.em.persist(null);
		} catch (Exception e) {
			System.out.print("SERVICIOS LIBROS: ---ERROR--- En metodo register");
			System.out.print(e);
		}
	}
}
