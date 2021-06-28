package com.example.hotelreservation;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://10.0.2.2:8080/")
                .build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }


}
