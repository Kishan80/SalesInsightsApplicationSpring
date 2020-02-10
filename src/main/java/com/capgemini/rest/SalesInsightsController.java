package com.capgemini.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.Admin;
import com.capgemini.entity.SalesExective;
import com.capgemini.exception.InvalidAdminException;
import com.capgemini.service.SalesInsightsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalesInsightsController {

	@Autowired
	private SalesInsightsService service;

	@PostMapping(value = "/addAdmin", consumes = "application/json")
	public String addAdmin(@RequestBody Admin admin) {
		service.addAdmin(admin);
		return "Added admin";
	}

	@PostMapping(value = "/getLoginDetails", consumes = "application/json")
	public String getLoginDetails(@RequestBody Admin login) throws InvalidAdminException {
		System.out.println("called");
		return service.getLoginDetails(login);
	}

	@PostMapping(value = "/registerSales", consumes = "application/json")
	public String registerSales(@RequestBody SalesExective sales) {
		service.registerSalesInfo((sales));
		return "Sales have been saved";
	}

	@GetMapping(value = "/editExecutive/{userId}/{userType}")
	public String editExecutive(@PathVariable String userId, @PathVariable String userType)
			throws InvalidAdminException {
		service.assignUserType(userId, userType);
		return "updated";
	}

	@GetMapping(value = "/getByCountry/{country}", produces = "application/json")
	public List<Admin> getByCountry(@PathVariable String country) throws InvalidAdminException {
		System.out.println(service.adminPage(country));
		return service.adminPage(country);
	}

	@GetMapping(value = "/salesByCountry", produces = "application/json")
	public List<Integer> salesByCountry() throws InvalidAdminException {

		return service.getSalesByLocation();
	}

	@GetMapping(value = "/salesByModel", produces = "application/json")
	public List<Integer> salesByModel() throws InvalidAdminException {
		return service.getSalesByModel();
	}

	@GetMapping(value = "/getExecutiveCountry/{userId}")
	public String getExecutiveCountry(@PathVariable String userId) throws InvalidAdminException {
		System.out.println(userId);
		return service.getExecutiveCountry(userId);
	}

}
