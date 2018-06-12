package com.journaldev.spring.service;

import java.util.List;

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

import com.journaldev.jpa.data.Employee;

@Component
public class EmployeeService {
	
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
	
	@Transactional
	public void register(Employee emp) {
		// Save employee
		this.em.persist(emp);
		
		
//		//Forma 1: Crear una transaccion propia
//		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//	        @Override
//	        protected void doInTransactionWithoutResult(TransactionStatus status) {
//	            em.createNativeQuery("TRUNCATE TABLE Employee").executeUpdate();
//	        }
//	    });

		
//		//Forma 2: Crear una transaccion propia	
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		def.setName("miTransaccion");
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		TransactionStatus status = transactionManager.getTransaction(def);
//		try {
//			em.createNativeQuery("TRUNCATE TABLE Employee").executeUpdate();
//		}
//		catch (Exception ex) {
//			transactionManager.rollback(status);
//		}
//		transactionManager.commit(status);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listar() {
		
		return em.createQuery("from Employee e").getResultList();
		
	}

	@Transactional
	public void eliminar(Employee emp) {
		
		Employee e = em.find(Employee.class, emp.getEmployeeId());
		em.remove(e);
	}

	@Transactional
	public void modificar(Employee employee) {
		em.merge(employee);
	}

}
