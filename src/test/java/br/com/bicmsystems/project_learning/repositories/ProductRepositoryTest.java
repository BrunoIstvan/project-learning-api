package br.com.bicmsystems.project_learning.repositories;

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
import br.com.bicmsystems.project_learning.v1.repositories.ProductRepository;


@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {

	@Mock
	private ProductRepository repo;
	
	@Test
	public void testCreateProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(30.0).stock(2).build();
		Product expected = Product.builder().name("Prod Test").price(30.0).stock(2).id(1L).build();
		when(repo.save(entity)).thenReturn(expected);
		Product test = repo.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		verify(repo).save(entity);
		
	}

	@Test
	public void testUpdateProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(40.0).stock(2).id(1L).build();
		Product expected = Product.builder().name("Prod Test").price(40.0).stock(2).id(1L).build();
		
		when(repo.save(entity)).thenReturn(expected);
		Product test = repo.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		assertThat(expected.getPrice(), equalTo(test.getPrice()));
		verify(repo).save(entity);
		
	}

	@Test
	public void testDeleteProduct() {
	
		Product entity = Product.builder().name("Prod Test").price(30.0).stock(2).build();
		repo.delete(entity);
		verify(repo).delete(entity);
		
	}

	@Test
	public void testGetProduct() {
	
		Optional<Product> expected = Optional.of(Product.builder().name("Prod Test").price(30.0).stock(2).id(1L).build());
		when(repo.findById(1L)).thenReturn(expected);
		Optional<Product> test = repo.findById(1L);
		assertEquals(expected, test);
		
	}
	
	@Test
	public void testFindAllProduct() {
		
		List<Product> list = new ArrayList<>(Arrays.asList(
				Product.builder().id(1L).name("Prod 1").price(1000.0).stock(1).build(),
				Product.builder().id(2L).name("Prod 2").price(2000.0).stock(1).build(),
				Product.builder().id(3L).name("Prod 3").price(3000.0).stock(1).build()
				));
		
		when(repo.findAll()).thenReturn(list);
		
		List<Product> test = repo.findAll();
		
		assertEquals(list, test);
		assertEquals(list.size(), test.size());
		assertThat(list.get(0).getId(), equalTo(test.get(0).getId()));
		
	}
	
}
