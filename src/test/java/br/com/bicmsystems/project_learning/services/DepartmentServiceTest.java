package br.com.bicmsystems.project_learning.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.bicmsystems.project_learning.v1.models.Department;
import br.com.bicmsystems.project_learning.v1.services.DepartmentService;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

	@Mock
	private DepartmentService service;
	
	@Test
	public void testCreateDepartment() {
		
		Department entity = Department.builder().name("Department Test").build();
		Department expected = Department.builder().name("Department Test").id(1).build();
		when(service.save(entity)).thenReturn(expected);
		
		Department test = service.save(entity);
		assertEquals(expected, test);
		assertEquals(expected.getId(), test.getId());
		verify(service).save(entity);
		
	}

}
