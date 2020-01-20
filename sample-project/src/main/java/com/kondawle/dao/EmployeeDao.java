package com.kondawle.dao;

import java.util.List;

import com.kondawle.model.Employee;

public interface EmployeeDao {
	
	public void add(Employee e);
	public void delete(Integer id);
	public List<Employee> view();

}
