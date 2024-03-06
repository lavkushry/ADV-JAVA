package com.tap.model;

public class DeliveryPartner {
	private int partnerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String vehicleType;
    private boolean available;
    
    
	public DeliveryPartner() {
	
	}

	public DeliveryPartner(int partnerId, String name, String phoneNumber, String email, String vehicleType,
			boolean available) {
		super();
		this.partnerId = partnerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vehicleType = vehicleType;
		this.available = available;
		
		
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
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
    
    
}
