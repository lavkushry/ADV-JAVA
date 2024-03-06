package com.tap;

class User{
	private int Userid;
	private String Username;
	private String password;
	private String email;
	private String address;
	private String role;
	
	
	public User() {
		super();
	}
	public User(int userid, String username, String password, String email, String address, String role) {
		super();
		Userid = userid;
		Username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
}

public class Program13PJO {

}
