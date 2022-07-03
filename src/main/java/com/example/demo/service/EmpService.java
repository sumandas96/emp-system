package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;

	public void addEmp(Employee e) {
		repo.save(e);	
	}

	public List<Employee> getAllEmp(){
		return repo.findAll();

	}

	public Employee getID(int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		else 
			return null;
	}
	
	public void deleteID(int id) {
		
		repo.deleteById(id);
	}
		
}