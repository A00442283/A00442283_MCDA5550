package com.example.hotelreservation;

import com.google.gson.Gson;

import java.util.List;

//import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface ApiInterface {

    //GET REQUEST FOR DISPLAYING THE HOTELS LIST
    @GET("/hotelsList")
    public void getHotelList(Callback<List<HotelListModel>> callback);


    //POST REQUEST FOR MAKING RESERVATIONS
    @Headers("Content-Type: application/json")
    @POST("/reservation")
    void createReservation(@Body String reservation, Callback<ReservationResponse> callback);

}
