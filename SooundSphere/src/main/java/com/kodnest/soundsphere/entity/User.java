package com.kodnest.soundsphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class User {

	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	String userid;
	String username;
	String email;
	String password;
	String gender;
	String role;
	String adress;
	boolean isPreminum;

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPreminum(boolean isPreminum) {
		this.isPreminum = isPreminum;
	}
	
	public User(String userid, String username, String email, String password, String gender, String role,
			String adress, boolean isPreminum) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.adress = adress;
		this.isPreminum = isPreminum;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", adress=" + adress + ", isPreminum=" + isPreminum + "]";
	}
	public String getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getRole() {
		return role;
	}
	public String getAdress() {
		return adress;
	}
	public boolean isPreminum() {
		return isPreminum;
	}

	
	

}
