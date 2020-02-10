package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales_executive")
public class SalesExective {
	@Id
	@GeneratedValue
	@Column(name="s_id")
	private int sId;
	@Column(length=10)
	private String country;
	@Column(length=10)
	private String branch;
	@Column(name="car_model",length=10)
	private String carModel;
	@Column(length=10)
	private String carId;
	@Column(length=20)
	private String customerName;
	@Column(length=16)
	private String customerId;
	@Column(length=20)
	private String address;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SalesExective [country=" + country + ", branch=" + branch + ", carModel=" + carModel + ", carId="
				+ carId + ", customerName=" + customerName + ", customerId=" + customerId + ", address=" + address
				+ "]";
	}
	
	

}
