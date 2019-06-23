package br.com.bicmsystems.project_learning.v1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.bicmsystems.project_learning.v1.models.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, 
										   JpaRepository<Product, Long> {
	
	public List<Product> findByDepartmentId(Integer departmentId);
	
	public List<Product> findByNameContainingIgnoreCase(String name);
	
	public Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
}
