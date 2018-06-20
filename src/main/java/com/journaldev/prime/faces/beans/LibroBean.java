package com.journaldev.prime.faces.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.journaldev.jpa.data.Libros;
import com.journaldev.spring.service.LibroDao;



@ManagedBean
@SessionScoped
public class LibroBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<Libros> lstLibros;

	@ManagedProperty("#{libroDao}")
	private LibroDao libroDao;

	private Libros libro = new Libros();

	public LibroDao getLibroDao() {
		return libroDao;
	}

	public void setLibroDao(LibroDao LibroService) {
		this.libroDao = LibroService;
	}

	public Libros getLibro() {
		return libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}
	
	

	public List<Libros> getLstLibros() {
		return lstLibros;
	}

	public void setLstLibros(List<Libros> lstLibros) {
		this.lstLibros = lstLibros;
	}
	
	public void listar(){
		
		lstLibros = libroDao.listar();
	}

	public String register() {
		System.out.println("------------------------------------------------");
		System.out.println("LIBRO BEAN: Iniciando metodo ---> register");
		// Calling Business Service
		libroDao.register(libro);
		String tit = libro.getTitulo();
		libro = new Libros();
		System.out.println("LIBRO BEAN: Libro " + libro.getTitulo() + " Insertado correctamente");
		listar();
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("El libro \""+tit+"\" ha sido registrado satisfactoriamente"));
		
		return "";
	}
	
	public boolean verificarSesion() {
		return true;
	}
	
	
	public void eliminar(Libros libro) {
		System.out.println("------------------------------------------------");
		System.out.println("LIBRO BEAN: Iniciando metodo ---> eliminar");
		
		libroDao.eliminar(libro);
		
		System.out.println("LIBRO BEAN: Metodo finalizado");
		listar();
	}
	
	public String leer(Libros libro) {
		
		System.out.println("------------------------------------------------");
		System.out.println("LIBRO BEAN: Iniciando metodo ---> leer");
		this.libro = libro;
		return "modify";
	}
	public String home() {
		return "index";
	}
	
	public String cerrarS() {
		return "login";
	}
	
	public String modificar() {
		System.out.println("------------------------------------------------");
		System.out.println("LIBRO BEAN: Iniciando metodo ---> modificar");
		System.out.println("Se modificara el libro: " + libro.getTitulo());
		libroDao.modificar(libro);
		System.out.println("LIBRO BEAN: Metodo finalizado");
		return "index";
	}
	
	public String cancelar() {
		
		return "index";
	}
	
	public void cerrarSesion() {
		
	}
	

}
