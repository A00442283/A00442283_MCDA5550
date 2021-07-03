package com.example.demo.model;

//Guest Model to store the guest details
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GuestModel")
public class GuestModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	public void setGender(String gender) {
		this.gender = GenderModel.valueOf(gender);
	}

}
