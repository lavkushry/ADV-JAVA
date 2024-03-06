package com.tap.model;

import java.awt.MenuItem;
import java.util.Date;
import java.util.List;

public class Restaurant {
	private int restaurantId;
	private String username;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String Address;
	private String role;
	private boolean isOpen;
	private Date createDate;
	private Date lastLoginDate;

	public Restaurant() {
		super();
	}

	public Restaurant(int restaurantId, String username, String password, String name, String phoneNumber, String email,
			String address, String role, boolean isOpen, Date createDate,
			Date lastLoginDate) {
		super();
		this.restaurantId = restaurantId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		Address = address;
		this.role = role;

		this.isOpen = isOpen;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
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
