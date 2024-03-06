package com.tap.model;

import java.util.Date;

public class DeliveryPartner {
	private int partnerId;
	private String username;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String role;
	private String vehicleType;
	private boolean available;
	private Date createDate;
	private Date lastLoginDate;

	public DeliveryPartner() {

	}

	public DeliveryPartner(int partnerId, String username, String password, String name, String phoneNumber,
			String email, String address, String role, String vehicleType, boolean available, Date createDate,
			Date lastLoginDate) {
		super();
		this.partnerId = partnerId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.role = role;
		this.vehicleType = vehicleType;
		this.available = available;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
