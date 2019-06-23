package br.com.bicmsystems.project_learning.v1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bicmsystems.project_learning.utils.PageableUtil;
import br.com.bicmsystems.project_learning.v1.models.Product;
import br.com.bicmsystems.project_learning.v1.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	public Product save(Product p) {
		
		return repo.save(p);
		
	}
	
	public List<Product> findAll() {
		
		return repo.findAll();
		
	}
	
	public Page<Product> findAll(String orderBy, String direction, int page, int size) {
		
		Pageable pageable = PageableUtil.getPageable(orderBy, direction, page, size);
		return repo.findAll(pageable);
		
	}

	public Optional<Product> findById(Long id) {
		
		return repo.findById(id);
		
	}
	
	public void deleteById(Long id) {
		
		repo.deleteById(id);
		
	}

	public List<Product> findAllByDeparment(Integer department_id) {
		
		return repo.findByDepartmentId(department_id);
		
	}

	public List<Product> findAllByName(String name) {
		
		return repo.findByNameContainingIgnoreCase(name);
		
	}
	
}
