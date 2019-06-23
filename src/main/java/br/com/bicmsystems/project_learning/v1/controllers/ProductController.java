package br.com.bicmsystems.project_learning.v1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bicmsystems.project_learning.enums.Direction;
import br.com.bicmsystems.project_learning.enums.ProductOrderBy;
import br.com.bicmsystems.project_learning.exceptions.PaginationSortingException;
import br.com.bicmsystems.project_learning.v1.models.Product;
import br.com.bicmsystems.project_learning.v1.services.ProductService;
import io.swagger.annotations.Api;

@Api(produces = MediaType.APPLICATION_JSON_VALUE, description = "Product API")
@RestController
@RequestMapping(path = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Product>> findById(
			@PathVariable("id") Long id) {
		
		return new ResponseEntity<Optional<Product>>(service.findById(id), HttpStatus.OK);
		
	}
	
	@PostMapping
	@ResponseBody 
	public ResponseEntity<Product> add(
			@RequestBody Product p) {

		return new ResponseEntity<Product>(service.save(p), HttpStatus.CREATED);
		
	}

	@DeleteMapping("/{id}")
	@ResponseBody 
	public ResponseEntity<Void> deleteById(
			@PathVariable("id") Long id) {

		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping
	@ResponseBody 
	public ResponseEntity<Void> delete(
			@RequestBody Product p) {

		service.deleteById(p.getId());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> update(
			@RequestBody Product p) {

		service.save(p);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping
	@ResponseBody 
	public ResponseEntity<List<Product>> findAll() {
		
		return new ResponseEntity<List<Product>>(service.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/paginated", params = { "orderBy", "direction", "page", "size" })
	@ResponseBody 
	public ResponseEntity<Page<Product>> findAllPaginated(
			@RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction, 
			@RequestParam("page") int page,
			@RequestParam("size") int size) {
		
		if (!(direction.equals(Direction.ASCENDING.getDirectionCode()) || 
				direction.equals(Direction.DESCENDING.getDirectionCode()))) {
			throw new PaginationSortingException("Invalid sort direction");
		}
		
		if (!(orderBy.equals(ProductOrderBy.ID.getOrderByCode()) || orderBy.equals(ProductOrderBy.NAME.getOrderByCode()) ||
			  orderBy.equals(ProductOrderBy.PRICE.getOrderByCode()) || orderBy.equals(ProductOrderBy.STOCK.getOrderByCode()))) {
			throw new PaginationSortingException("Invalid orderBy condition");
		}
		
		return new ResponseEntity<Page<Product>>(service.findAll(orderBy, direction, page, size), HttpStatus.OK);
		
	}

	@GetMapping("/name")
	@ResponseBody
	public ResponseEntity<List<Product>> findAllByName(
			@RequestParam("search") String search) {
		
		return new ResponseEntity<List<Product>>(service.findAllByName(search), HttpStatus.OK);
		
	}
	
	@GetMapping("/{department_id}/department")
	@ResponseBody
	public ResponseEntity<List<Product>> findAllByDeparment(
			@PathVariable("department_id") Integer department_id) {
		
		return new ResponseEntity<List<Product>>(service.findAllByDeparment(department_id), HttpStatus.OK);
		
	}
	
}
