package br.com.bicmsystems.project_learning.v1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bicmsystems.project_learning.exceptions.ResourceNotFoundException;
import br.com.bicmsystems.project_learning.v1.models.Department;
import br.com.bicmsystems.project_learning.v1.services.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(path = "/api/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Find department by code")
	@ApiResponses(value = { 
	        @ApiResponse(code = 500, message = "Server error") })
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Department> findById(
			@ApiParam(value = "Department code", example = "2", required = true) 
			@PathVariable("id") Integer id) throws ResourceNotFoundException {
		
		Department dep = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found id :: " + id));
		
		return ResponseEntity.ok(dep);
		
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, value = "Add a new department")
	@ApiResponses(value = { 
		        @ApiResponse(code = 405, message = "Invalid input"),
		        @ApiResponse(code = 500, message = "Server error") })
	@PostMapping
	@ResponseBody 
	public ResponseEntity<Department> add(
			@ApiParam(value = "Department object that needs to be saved",
					  required = true)
			@Valid @RequestBody Department d) {

		return new ResponseEntity<Department>(service.save(d), HttpStatus.CREATED);
		
	}

	@DeleteMapping
	@ResponseBody 
	public ResponseEntity<Void> delete(@Valid @RequestBody Department d) throws ResourceNotFoundException {

		service.deleteById(d.getId());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}

	@DeleteMapping("/{id}")
	@ResponseBody 
	public ResponseEntity<Void> deleteById(
			@PathVariable("id") Integer id) throws ResourceNotFoundException {

		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> update(
			@RequestBody Department d) throws ResourceNotFoundException {

		service.update(d);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping
	@ResponseBody 
	public ResponseEntity<List<Department>> listAll() {
		
		return new ResponseEntity<List<Department>>(service.findAll(), HttpStatus.OK);
		
	}
	
}
