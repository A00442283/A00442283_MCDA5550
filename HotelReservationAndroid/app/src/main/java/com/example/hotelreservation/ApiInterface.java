package com.example.hotelreservation;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {

    @GET("/hotelsList")
    public void getHotelList(Callback<List<HotelListModel>> callback);
}
