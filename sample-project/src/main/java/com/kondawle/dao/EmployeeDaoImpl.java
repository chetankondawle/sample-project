package com.kondawle.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kondawle.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	public void delete(Integer id) {
		Employee e=sessionFactory.getCurrentSession().load(Employee.class, id);
		sessionFactory.getCurrentSession().remove(e);
	}

	public List<Employee> view() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

}
