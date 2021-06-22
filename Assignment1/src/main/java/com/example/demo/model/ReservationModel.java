package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class ReservationModel {
	
	private int reservationID;
	private Date checkin;
	private Date checkout;
	private List<GuestModel> guests_list;
	
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public List<GuestModel> getGuests_list() {
		return guests_list;
	}
	public void setGuests_list(List<GuestModel> guests_list) {
		this.guests_list = guests_list;
	}
	

}
