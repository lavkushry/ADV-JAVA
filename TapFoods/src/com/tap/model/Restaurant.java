package com.tap.model;

import java.awt.MenuItem;
import java.util.List;

public class Restaurant {
	private int restaurantId;
    private String name;
    private String phoneNumber;
    private String email;
    private String Address;
    private String operatingHours;
    private List<MenuItem> menuItems;
    private boolean isOpen;
    
    
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String name, String phoneNumber, String email, String address,
			String operatingHours, List<MenuItem> menuItems, boolean isOpen) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		Address = address;
		this.operatingHours = operatingHours;
		this.menuItems = menuItems;
		this.isOpen = isOpen;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
    
	

}
