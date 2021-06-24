package com.example.demo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import com.example.demo.model.*;

@Entity
@Table(name = "ReservationModel")
public class ReservationModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationID;
	private Date checkin;
	private Date checkout;
	
	@OneToMany(targetEntity=GuestModel.class,cascade = {CascadeType.ALL})
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
	public void setCheckin(String checkin) {
		try {
			this.checkin = new SimpleDateFormat("dd/MM/yyyy").parse(checkin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		try {
			this.checkout = new SimpleDateFormat("dd/MM/yyyy").parse(checkout);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<GuestModel> getGuests_list() {
		return guests_list;
	}
	public void setGuests_list(List<GuestModel> guests_list) {
		this.guests_list = guests_list;
	}
	

}
