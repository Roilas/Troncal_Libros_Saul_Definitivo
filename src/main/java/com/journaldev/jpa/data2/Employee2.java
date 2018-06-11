package com.journaldev.jpa.data2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="employee")
@NamedQuery(name="Employee2.findAll", query="SELECT e FROM Employee e")
public class Employee2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID", unique=true, nullable=false)
	private Long employeeId;

	@Column(name="EMP_NAME", nullable=false, length=45)
	private String employeeName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EMP_HIRE_DATE", nullable=false)
	private Date employeeHireDate;

	@Column(name="EMP_SALARY", nullable=false, precision=10, scale=4)
	private Double employeeSalary;

	public Employee2() {
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getEmployeeHireDate() {
		return this.employeeHireDate;
	}

	public void setEmployeeHireDate(Date employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeSalary() {
		return this.employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}