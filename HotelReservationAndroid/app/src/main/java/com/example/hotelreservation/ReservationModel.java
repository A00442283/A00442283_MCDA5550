package com.example.hotelreservation;

import java.util.List;

public class ReservationModel {

    private String reservationID;
    private String checkin;

    @Override
    public String toString() {
        return "{"+
                "checkin=" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", guests_list=" + guests_list +
                '}';
    }

    private String checkout;

    private List<GuestModel> guests_list;

    public ReservationModel(String checkin,String checkout,List<GuestModel> guests_list) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.guests_list=guests_list;
    }

    public String getReservationID() {
        return reservationID;
    }
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
    public String getCheckin() {
        return checkin;
    }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public List<GuestModel> getGuests_list() {
        return guests_list;
    }
    public void setGuests_list(List<GuestModel> guests_list) {
        this.guests_list = guests_list;
    }

}
