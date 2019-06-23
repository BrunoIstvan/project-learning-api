package br.com.bicmsystems.project_learning.v1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.bicmsystems.project_learning.v1.models.Product;

@Service
public interface ProductService {

	public Product save(Product p);
	
	public List<Product> findAll();
	
	public Page<Product> findAll(String orderBy, String direction, int page, int size);

	public Optional<Product> findById(Long id);
	
	public void deleteById(Long id);

	public List<Product> findAllByDeparment(Integer department_id);

	public List<Product> findAllByName(String name);
	
}
