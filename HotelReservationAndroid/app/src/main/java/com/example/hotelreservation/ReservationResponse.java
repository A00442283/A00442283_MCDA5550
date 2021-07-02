package com.example.hotelreservation;

public class ReservationResponse {

    private String confirmation_number;

    public ReservationResponse(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }

    public String getConfirmation_number() {
        return confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }



}
