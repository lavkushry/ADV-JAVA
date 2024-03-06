package com.foodDelivery.model;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String cusineType;
	private String deliveryTime;
	private String address;
	private float rating;
	private float isActive;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(int restaurantId, String name, String cusineType, String deliveryTime, String address,
			float rating, float isActive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cusineType = cusineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
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

	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getIsActive() {
		return isActive;
	}

	public void setIsActive(float isActive) {
		this.isActive = isActive;
	}


	

}
