package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.example.demo.*;

//Hotel Reservation Model stores hotel name and reservations
@Entity
@Table(name = "HotelReservationModel")
public class HotelReservationModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hotel_name;
	
	@OneToOne(targetEntity=ReservationModel.class,cascade = {CascadeType.ALL})
	private ReservationModel reservation;
	
	public HotelReservationModel(String hotel_name, ReservationModel reservation) {
		this.id=0;
		this.hotel_name = hotel_name;
		this.setReservation(reservation);
	}
	
	public HotelReservationModel() {
		
	}
	
	public ReservationModel getReservation() {
		return reservation;
	}
	public void setReservation(ReservationModel reservation) {
		this.reservation = reservation;
	}
	public long getId() {
		return id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


}
