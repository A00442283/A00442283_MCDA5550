package com.example.hotelreservation;

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

    @GET("/hotelsList")
    public void getHotelList(Callback<List<HotelListModel>> callback);


    //public void createReservation(@Body HotelReservationModel reservation,Callback<HotelReservationModel> callback);


    //Callback<HotelReservationModel> createReservation(Callback<List<HotelListModel>> listCallback);

    @POST("/reservation")
    void createReservation(@Body HotelReservationModel reservation, Callback<HotelReservationModel> callback);

}
