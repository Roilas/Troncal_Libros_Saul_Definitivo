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
		listar();
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
		employeeService.register(employee);
		listar();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("El empleado "+this.employee.getEmployeeName()+" se ha registrado con éxito"));
		employee = new Employee();
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
		this.employee = emp;
		return "editar";
	}
	
	public void cerrarSesion() {
		
	}
	
	private TimeZone timeZone;
	public TimeZone getTimeZone() {  
		  TimeZone timeZone = TimeZone.getDefault();  
		  return timeZone;  
	}  
	
	public String modificar() {
		employeeService.modificar(employee);
		listar();
		employee = new Employee();
		return "index?faces-redirect=true";
	}
	public String cancelar() {
		return "index?faces-redirect=true";
	}
}
