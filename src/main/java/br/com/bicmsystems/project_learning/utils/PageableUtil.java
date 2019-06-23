package br.com.bicmsystems.project_learning.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageableUtil {

	public static Pageable getPageable(String orderBy, String direction, int page, int size) {
		
		Sort sort = null;
		if (direction.equals("ASC")) {
			sort = Sort.by(new Sort.Order(Direction.ASC, orderBy));
		}
		if (direction.equals("DESC")) {
			sort = Sort.by(new Sort.Order(Direction.DESC, orderBy));
		}
		
		Pageable pageable = PageRequest.of(page, size, sort);
		return pageable;
		
	}
	
}
