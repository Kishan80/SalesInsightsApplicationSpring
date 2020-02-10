package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.entity.Admin;
import com.capgemini.entity.SalesExective;
import com.capgemini.exception.InvalidAdminException;

public interface SalesInsightsService {
	void addAdmin(Admin admin); 
	String getLoginDetails(Admin login) throws InvalidAdminException;//validate login
	
	List<Admin> adminPage(String country) throws InvalidAdminException;//admin page
	void assignUserType(String userId,String userType) throws InvalidAdminException;//edit executive
	void registerSalesInfo(SalesExective salesExecutive);//sales page
	List<Integer> getSalesByLocation() throws InvalidAdminException;//executive page
	List<Integer> getSalesByModel() throws InvalidAdminException;
	String getExecutiveCountry(String userId) throws InvalidAdminException;

}
