package br.com.bicmsystems.project_learning.repositories;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.bicmsystems.project_learning.v1.models.Department;
import br.com.bicmsystems.project_learning.v1.repositories.DepartmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentRepositoryTest {

	@Mock
	private DepartmentRepository repo;
	
	@Test
	public void testCreateDepartment() {
		
		Department entity = Department.builder().name("Department 1").build();
		Department expected = Department.builder().name("Department 1").id(1).build();
		
		when(repo.save(entity)).thenReturn(expected);
		Department test = repo.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		verify(repo).save(entity);
		
	}
	
	@Test
	public void testUpdateDepartment() {
		
		Department entity = Department.builder().name("Department test").id(1).build();
		Department expected = Department.builder().name("Department test").id(1).build();
		
		when(repo.save(any(Department.class))).thenReturn(expected);
		Department test = repo.save(entity);
		assertThat(expected, equalTo(test));
		verify(repo).save(entity);
		
	}
	
	@Test
	public void testDeleteDepartment() {
		
		Department entity = Department.builder().name("Department test").build();
		repo.delete(entity);
		verify(repo).delete(entity);
		
	}
	
	@Test
	public void testGetDepartment() {
		
		Optional<Department> expected = Optional.of(Department.builder().id(1).name("Department test").build());
		
		when(repo.findById(1)).thenReturn(expected);
		Optional<Department> test = repo.findById(1);
		assertEquals(expected, test);
		
	}
	
	@Test
	public void testFindAllProduct() {
	
		List<Department> list = new ArrayList<>(Arrays.asList(
				Department.builder().id(1).name("Department 1").build(),
				Department.builder().id(2).name("Department 2").build(),
				Department.builder().id(3).name("Department 3").build(),
				Department.builder().id(4).name("Department 4").build(),
				Department.builder().id(5).name("Department 5").build()
				));
		
		when(repo.findAll()).thenReturn(list);
		
		List<Department> test = repo.findAll();
		
		assertEquals(list, test);
		assertEquals(list.size(), test.size());
		assertThat(list.get(0).getId(), equalTo(test.get(0).getId()));
		
	}
	
}
