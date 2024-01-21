package com.springMVC.thymeleaf.validationProject.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define default course code
	public String value() default "LUV";
	
	//define default error message
	public String message() default "must start with LUV";
	
	//define default groups
	//we are not going to use groups. 
	//so we just give the basic boilerplate of groups and give empty collection.
	public Class<?>[] groups() default {};
	
	//define default payloads
	//we are not going to use payload. 
	//so we just give the default for payloads.
	public Class<? extends Payload>[] payload() default {};
}
