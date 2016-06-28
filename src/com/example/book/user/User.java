package com.example.book.user;

import java.io.Serializable;

public class User  implements Serializable {
	private String username;
	private String password;
	private String repassword;
	private int phone;
	private String type;
	
	public User() {
		super();
		
	}
	public User(String username, String password, String repassword, int phone, String type) {
		super();
		this.username = username;
		this. password =  password;
		this.repassword = repassword;
		this.phone = phone;
		this.type = type;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String toString() {
		return "User [username=" + username + ", password="
				+ password + ", repassword=" + repassword + ", phone=" + phone +  ", type=" + type + "]";
	}
	
}
