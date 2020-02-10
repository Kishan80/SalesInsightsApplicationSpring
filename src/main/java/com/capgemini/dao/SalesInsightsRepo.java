package com.capgemini.dao;


import java.util.List;

import com.capgemini.entity.Admin;
import com.capgemini.entity.SalesExective;
import com.capgemini.exception.InvalidAdminException;

public interface SalesInsightsRepo {
	
	
	void addAdmin(Admin admin); 
	Admin getLoginDetails(Admin admin) throws InvalidAdminException;//validate login
	
	List<Admin> adminPage(String country) throws InvalidAdminException;//admin page
	void assignUserType(String userId,String userType) throws InvalidAdminException;//edit executive
	void registerSalesInfo(SalesExective salesExecutive);//sales page
	List<Integer> getSalesByLocation() throws InvalidAdminException;//executive page
	List<Integer> getSalesByModel() throws InvalidAdminException;
	String getExecutiveCountry(String userId) throws InvalidAdminException;
}
