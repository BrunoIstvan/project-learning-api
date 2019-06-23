package br.com.bicmsystems.project_learning.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;
	
}
