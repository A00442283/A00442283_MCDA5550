package com.example.hotelreservation;

public class HotelReservationModel {

    @Override
    public String toString() {
        return "{" +
                "hotel_name" + hotel_name + '\'' +
                ", reservation" + reservation +
                '}';
    }

    private String hotel_name;
    private ReservationModel reservation;

    public HotelReservationModel(String hotel_name, ReservationModel reservation) {
        this.hotel_name = hotel_name;
        this.setReservation(reservation);
    }


    public ReservationModel getReservation() {
        return reservation;
    }

    public void setReservation(ReservationModel reservation) {
        this.reservation = reservation;
    }

    public String getHotel_name() {
        return hotel_name;
    }


    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

}
