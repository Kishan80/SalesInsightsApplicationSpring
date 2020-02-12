package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.SalesInsightsRepo;
import com.cg.entity.Admin;
import com.cg.entity.SalesExective;
import com.cg.exception.InvalidAdminException;

@Service
public class SalesInsightsServiceImpl implements SalesInsightsService {
	@Autowired
	private SalesInsightsRepo repository;

	@Override
	public void addAdmin(Admin admin) {
		repository.addAdmin(admin);

	}

	@Override
	public String getLoginDetails(Admin login) throws InvalidAdminException {
		Admin admin = repository.getLoginDetails(login);
		String userName = admin.getUserId();
		String pass = admin.getPassword();
		if (userName.equals(login.getUserId())) {
			if (pass.equals(login.getPassword())) {
				return "true";
			} else
				return "false";
		} else
			return "false";
	}

	@Override
	public List<Admin> adminPage(String country) throws InvalidAdminException {

		return repository.adminPage(country);
	}

	@Override
	public void assignUserType(String userId, String userType) throws InvalidAdminException {
		repository.assignUserType(userId, userType);

	}

	@Override
	public void registerSalesInfo(SalesExective salesExecutive) {
		repository.registerSalesInfo(salesExecutive);

	}

	@Override
	public List<Integer> getSalesByLocation() throws InvalidAdminException {

		return repository.getSalesByLocation();
	}

	@Override
	public List<Integer> getSalesByModel() throws InvalidAdminException {

		return repository.getSalesByModel();
	}

	@Override
	public String getExecutiveCountry(String userId) throws InvalidAdminException {
		// TODO Auto-generated method stub
		return repository.getExecutiveCountry(userId);
	}

}
