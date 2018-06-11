package com.journaldev.prime.faces.beans;

import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.journaldev.jpa.data.Employee;
import com.journaldev.spring.service.EmployeeService;

@ManagedBean
@SessionScoped
public class RegisterEmployee {

	private List<Employee> lstEmpleados;
	
	public List<Employee> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Employee> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee = new Employee();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getEmployeeName()+" Is Registered Successfully"));
		return "";
	}
	
	public boolean verificarSesion(){
		return true;      
	}
	
	public void listar(){
		
		lstEmpleados = employeeService.listar();
	}
	
	public void eliminar( Employee emp) {
		employeeService.eliminar(emp);
		listar();
	}
	
	public String leer (Employee emp) {
		return "editar";
	}
	
	public void cerrarSesion() {
		
	}
	
	private TimeZone timeZone;
	public TimeZone getTimeZone() {  
		  TimeZone timeZone = TimeZone.getDefault();  
		  return timeZone;  
	}  
}
