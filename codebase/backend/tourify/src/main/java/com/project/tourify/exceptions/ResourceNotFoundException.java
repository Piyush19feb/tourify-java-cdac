package com.project.tourify.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	
	String fieldName;
	
	Long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public ResourceNotFoundException(String resourceName, String fieldName) {
		super(String.format("%s not found with %s", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}
}
