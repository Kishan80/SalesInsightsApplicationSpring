package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.SalesExective;
import com.cg.exception.InvalidAdminException;

@Repository
@Transactional
public class SalesInsightsRepoImpl implements SalesInsightsRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Admin getLoginDetails(Admin login) throws InvalidAdminException {
		if (em.find(Admin.class, login.getUserId()) != null
				&& em.find(Admin.class, login.getUserId()).getUserType().equals(login.getUserType())) {
			String str = "select executive from Admin executive where executive.userId=:uId and executive.userType=:uType";
			TypedQuery<Admin> query = em.createQuery(str, Admin.class);
			query.setParameter("uId", login.getUserId());
			query.setParameter("uType", login.getUserType());
			Admin foundUser = query.getSingleResult();
			System.out.println(foundUser);
			return foundUser;
		} else
			throw new InvalidAdminException("Invalid User ID or Type");

	}

	@Override
	public List<Admin> adminPage(String country) throws InvalidAdminException {

		Query query = em.createNativeQuery("select user_id,user_type from Admin admin where admin.country=:c");

		query.setParameter("c", country);

		if (query.getResultList() != null) {
			List<Admin> adminListdb = query.getResultList();
			return adminListdb;
		} else
			throw new InvalidAdminException("No Executives with the country" + country);
	}

	@Override
	public void assignUserType(String userId, String userType) throws InvalidAdminException {
		Admin ad = em.find(Admin.class, userId);
		if (ad != null) {
			ad.setUserType(userType);
			em.merge(ad);
		} else
			throw new InvalidAdminException("Update could not be done");

	}

	@Override
	public void registerSalesInfo(SalesExective salesExecutive) {
		em.persist(salesExecutive);
	}

	@Override
	public void addAdmin(Admin admin) {
		em.persist(admin);
	}

	@Override
	public List<Integer> getSalesByLocation() throws InvalidAdminException {
		// Query query = em.createQuery("select count(*) from SalesExective sales where
		// sales.country=:c");
		Query query = em.createQuery("select country from SalesExective");
		// List<String> countries = query1.getResultList();
		List<String> countries = new ArrayList<>();
		if (query.getResultList() != null) {
			countries = query.getResultList();
			// System.out.println(countries);
			int india = 0, australia = 0, germany = 0, france = 0;
			for (String s : countries) {
				if (s.equals("India") && s != null)
					india++;
				else if (s.equals("Germany") && s != null)
					germany++;
				else if (s.equals("France") && s != null)
					france++;
				else if (s.equals("Australia") && s != null)
					australia++;
			}
			List<Integer> countryCount = new ArrayList<>();
			countryCount.add(0, india);
			countryCount.add(1, australia);
			countryCount.add(2, germany);
			countryCount.add(3, france);
			return countryCount;
		} else
			throw new InvalidAdminException("No Sales found");

	}

	@Override
	public List<Integer> getSalesByModel() throws InvalidAdminException {
		Query query1 = em.createQuery("select carModel from SalesExective");

		List<String> countries = query1.getResultList();
		int A = 0, C = 0, E = 0, S = 0;
		for (String s : countries) {
			if (s.equalsIgnoreCase("a Class"))
				A++;
			else if (s.equalsIgnoreCase("C Class"))
				C++;
			else if (s.equalsIgnoreCase("E Class"))
				E++;
			else if (s.equalsIgnoreCase("S Class"))
				S++;
		}
		List<Integer> modelCount = new ArrayList<>();
		modelCount.add(0, A);
		modelCount.add(1, C);
		modelCount.add(2, E);
		modelCount.add(3, S);
		System.out.println(countries);

		return modelCount;
	}

	@Override
	public String getExecutiveCountry(String userId) throws InvalidAdminException {
		if (em.find(Admin.class, userId) != null) {
			Query query = em.createNativeQuery("select country from Admin admin where admin.user_id=:uId");

			query.setParameter("uId", userId);

			return (String) query.getSingleResult();
		} else
			throw new InvalidAdminException("No Executive found");

	}

}
