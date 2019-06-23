package br.com.bicmsystems.project_learning.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.bicmsystems.project_learning.v1.models.Product;
import br.com.bicmsystems.project_learning.v1.services.ProductService;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductService service;
	
	@Test
	public void testCreateProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(30.0).stock(2).build();
		Product expected = Product.builder().name("Prod Test").price(30.0).stock(2).id(1L).build();
		when(service.save(entity)).thenReturn(expected);
		Product test = service.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		verify(service).save(entity);
		
	}

	@Test
	public void testUpdateProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(40.0).stock(2).id(1L).build();
		Product expected = Product.builder().name("Prod Test").price(40.0).stock(2).id(1L).build();
		when(service.save(entity)).thenReturn(expected);
		Product test = service.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		assertThat(expected.getPrice(), equalTo(test.getPrice()));
		verify(service).save(entity);
		
	}

	@Test
	public void testDeleteProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(30.0).stock(2).build();
		service.deleteById(entity.getId());
		verify(service).deleteById(entity.getId());
		
	}

	@Test
	public void testGetProduct() {
	
		Optional<Product> expected = Optional.of(Product.builder().name("Prod Test").price(30.0).stock(2).id(1L).build());
		when(service.findById(1L)).thenReturn(expected);
		Optional<Product> test = service.findById(1L);
		assertEquals(expected, test);
		
	}
	
	@Test
	public void testFindAllProduct() {
		
		List<Product> list = new ArrayList<>(Arrays.asList(
				Product.builder().id(1L).name("Prod 1").price(1000.0).stock(1).build(),
				Product.builder().id(2L).name("Prod 2").price(2000.0).stock(1).build(),
				Product.builder().id(3L).name("Prod 3").price(3000.0).stock(1).build()
				));
		
		when(service.findAll()).thenReturn(list);
		
		List<Product> test = service.findAll();
		
		assertEquals(list, test);
		assertEquals(list.size(), test.size());
		
	}
	
	
}
