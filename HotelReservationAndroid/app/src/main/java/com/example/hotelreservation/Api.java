package com.example.hotelreservation;

import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class Api {

    public static ApiInterface getClient() {

        //SET ENDS POINT TO AWS ELASTIC BEANSTALK
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com")
                .build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }

}
