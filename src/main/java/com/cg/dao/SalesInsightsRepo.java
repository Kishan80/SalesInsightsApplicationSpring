package com.cg.dao;


import java.util.List;

import com.cg.entity.Admin;
import com.cg.entity.SalesExective;
import com.cg.exception.InvalidAdminException;

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
