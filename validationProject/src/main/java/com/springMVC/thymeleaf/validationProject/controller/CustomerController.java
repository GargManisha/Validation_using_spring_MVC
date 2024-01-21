package com.springMVC.thymeleaf.validationProject.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springMVC.thymeleaf.validationProject.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	// add an initBinder to trim the input strings.
	//remove whitespace (leading and tailing)
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showForm(Model themodel) {
		themodel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCusotmer, 
			BindingResult bindingResult) {
		System.out.println(bindingResult);
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";		
		}
	}
}
