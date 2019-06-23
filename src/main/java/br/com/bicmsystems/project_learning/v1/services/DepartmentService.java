package br.com.bicmsystems.project_learning.v1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bicmsystems.project_learning.exceptions.ResourceNotFoundException;
import br.com.bicmsystems.project_learning.v1.models.Department;

@Service
public interface DepartmentService {

	public Department save(Department entity);
	
	public Department update(Department entity) throws ResourceNotFoundException;

	public List<Department> findAll();

	public void deleteById(Integer id) throws ResourceNotFoundException;
	
	public void delete(Department dep) throws ResourceNotFoundException;

	public Optional<Department> findById(Integer id);
	
	public List<Department> findByName(String name);
	
}
