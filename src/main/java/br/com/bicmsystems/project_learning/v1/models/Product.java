package br.com.bicmsystems.project_learning.v1.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Validated
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(example = "1", required = true, value = "Product code")
	private Long id;
	
	@NotNull
	@ApiModelProperty(example = "Barbie doll", required = true, value = "Product name")
	private String name;
	
	@NotNull
	@ApiModelProperty(example = "300.00", required = true, value = "Product price")
	private Double price;
	
	@NotNull
	@ApiModelProperty(example = "30", required = true, value = "Product stock")
	private Integer stock;	
	
	@ManyToOne
	@NotNull
	private Department department;
	
	
}
