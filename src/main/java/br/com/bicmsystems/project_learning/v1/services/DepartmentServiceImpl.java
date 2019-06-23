package br.com.bicmsystems.project_learning.v1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bicmsystems.project_learning.exceptions.ResourceNotFoundException;
import br.com.bicmsystems.project_learning.v1.models.Department;
import br.com.bicmsystems.project_learning.v1.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	@Override
	public Department save(Department entity) {
		
		return repo.save(entity);
		
	}
	
	@Override
	public Department update(Department entity) throws ResourceNotFoundException {
		
		Department dep = repo.findById(entity.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Department not found id :: " + entity.getId()));
		
		return repo.save(dep);
		
	}

	@Override
	public List<Department> findAll() {
		
		return repo.findAll();
		
	}

	@Override
	public void deleteById(Integer id) throws ResourceNotFoundException {
		
		Department dep = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found id :: " + id));
		
		repo.delete(dep);
		
	}
	
	@Override
	public void delete(Department dep) throws ResourceNotFoundException {
		
		Department exists = repo.findById(dep.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Department not found id :: " + dep.getId()));
		
		repo.delete(exists);
		
	}

	@Override
	public Optional<Department> findById(Integer id) {
		
		return repo.findById(id);
		
	}
	
	@Override
	public List<Department> findByName(String name) {
		
		return repo.findByName(name);
		
	}
	
}
