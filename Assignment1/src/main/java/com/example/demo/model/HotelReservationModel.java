package com.example.demo.model;

public class HotelReservationModel {
	private ReservationModel reservation;
	private final long id;
	private final String hotel_name;
	
	public HotelReservationModel(String hotel_name, ReservationModel reservation) {
		this.id=0;
		this.hotel_name = hotel_name;
		this.setReservation(reservation);
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


}
