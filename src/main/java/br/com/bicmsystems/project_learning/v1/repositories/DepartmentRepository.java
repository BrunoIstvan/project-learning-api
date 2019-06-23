package br.com.bicmsystems.project_learning.v1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.bicmsystems.project_learning.v1.models.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Integer>,
											  JpaRepository<Department, Integer> {

	public List<Department> findByName(String name);
	
	public Page<Department> findByName(String name, Pageable pageable);
	
}
