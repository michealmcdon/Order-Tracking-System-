package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.services.CustomerServices;


public class CustomerController {
		
		@Autowired 
		
		CustomerServices cs;
		
		@RequestMapping(value = "/showCust.html")
		public String listCustomers(Model model) {
			ArrayList<Customer> customers= cs.findAll();
			model.addAttribute("custs", customers);
			
			return "allCustomers";
			
		}
		//Get request
		@RequestMapping(value = "addCust.html", method = RequestMethod.GET)
		public String addCustomers(Model model) {
			ArrayList<Customer> customers = cs.findAll();
			
			Map<String, Long> customerList = new LinkedHashMap<String, Long>();
			for (Customer c : customers) {
				customerList.put(c.getcName(), c.getcId());
			}
			
			model.addAttribute("customerList", customerList);
			Customer c = new Customer();
			model.addAttribute("newCust", c);
			
			return "addCustomer";
		}


		@RequestMapping(value = "addCust.html", method = RequestMethod.POST)
		public String addCustomerPost(@ModelAttribute("newCust")@Valid Customer c, BindingResult result) {
			if (result.hasErrors()) {
				cs.save(c);
				
				return "redirect:showCust.html";
			}

			return "index";
		}
		

	}


