package com.example.hotelreservation;

public class GuestModel {

    private String guest_name;
    private String gender;

    @Override
    public String toString() {
        return "{" +
                "guest_name='" + guest_name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public GuestModel(String guest, String gender_) {
        guest_name=guest;
        gender=gender_;
    }

    public String getGuest_name() {
        return guest_name;
    }
    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}
