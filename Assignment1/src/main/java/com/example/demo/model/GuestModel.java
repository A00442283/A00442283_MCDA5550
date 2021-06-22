package com.example.demo.model;

public class GuestModel {
	private String guest_name;
	private GenderModel gender;
	
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	
	public GenderModel getGender() {
		return gender;
	}
	public void setGender(GenderModel gender) {
		this.gender = gender;
	}

}
