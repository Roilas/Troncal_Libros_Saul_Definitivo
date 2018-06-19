package com.TroncalLibrosSaul.prime.faces.beans;


import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.TroncalLibrosSaul.ClasesBasicas.Libro;
import com.TroncalLibrosSaul.Services.ServiciosLibros;


//@ManagedProperty("#{employeeService}")
//private EmployeeService employeeService;
//
//private Employee employee = new Employee();
//

@ManagedBean
@SessionScoped
public class GestorLibros{



//	@ManagedProperty("#{ServiciosLibros}")
	private ServiciosLibros serviciosLibros = new ServiciosLibros();

	private Libro libro = new Libro();
	
	

	



	public ServiciosLibros getServiciosLibros() {
		return serviciosLibros;
	}







	public void setServiciosLibros(ServiciosLibros serviciosLibros) {
		this.serviciosLibros = serviciosLibros;
	}







	public Libro getLibro() {
		return libro;
	}







	public void setLibro(Libro libro) {
		libro = libro;
	}







	public String Registrar() {
		try {
			System.out.print("-------------------------------------");
			System.out.print("GESTOR LIBROS: Introduciendo...");
			
			serviciosLibros.register(libro);
//			serviciosLibros.register(libro);
			System.out.print("GESTOR LIBROS: Tarea finalizada con exito");
			libro = new Libro();
			
		} catch (Exception e) {
			System.out.print(e);
		}
		return "";
	}
	
	
}
