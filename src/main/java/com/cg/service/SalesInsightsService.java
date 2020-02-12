package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.SalesExective;
import com.cg.exception.InvalidAdminException;

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
