package com.springMVC.thymeleaf.validationProject.model;

import com.springMVC.thymeleaf.validationProject.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min=1,message = "minimum 1 character is required")
	private String lastName;
	
	@Min(value=0,message = "must be greater than or equals to 0")
	@Max(value=10,message = "must be less than or equals to 10")
	@NotNull(message = "is required")
	private Integer freePass;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 characters/digits are allowed")
	private String postalCode;
	
	@CourseCode(value="TOP",message = "must start with TOP.")
	private String courseCode;
	
	public Customer() {
		
	}
}
