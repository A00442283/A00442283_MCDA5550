package com.example.demo.model;

public class ReservationResponse {
	
	private String confirmation_number;

	public ReservationResponse(String reservationID) {
		// TODO Auto-generated constructor stub
		this.confirmation_number=reservationID;
	}

	public String getConfirmation_number() {
		return confirmation_number;
	}

	public void setConfirmation_number(String confirmation_number) {
		this.confirmation_number = confirmation_number;
	}

}
