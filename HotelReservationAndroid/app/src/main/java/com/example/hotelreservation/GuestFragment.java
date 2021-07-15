package com.example.hotelreservation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GuestFragment extends Fragment {
    TextView checkOutDateSelected, checkInDateSelected, guestName, guestCount;
    List<GuestModel> guestArrayList = new ArrayList<>();;
    ArrayList<GuestModel> list;
    View view;
    Button addGuest;
    GuestListAdapter guestAdapter;
    RadioGroup radioGender;
    RadioButton radioFemale;
    RadioButton radioMale;
    RadioButton radioBtn;
    ListView guestList;
    ArrayAdapter<GuestModel> arrayAdapter;
    Button bookNext, clear;
    String hotelName;

    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    public static final String nameKey = "nameKey";
    public static final String checkIn = "checkIn";
    public static final String checkOut = "checkOut";
    public static final String guestsCount = "guestsCount";

    public static GuestFragment newInstance(String hotel_name) {
        GuestFragment fragment=new GuestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hotelName",hotel_name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guest_list_fragment,container,false);

        if(getArguments() != null){
            hotelName=getArguments().getString("hotelName");
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        checkInDateSelected = view.findViewById(R.id.selected_check_in);
        checkOutDateSelected = view.findViewById(R.id.selected_check_out);
        guestName = view.findViewById(R.id.selected_name);
        guestCount = view.findViewById(R.id.selected_count);

        addGuest = view.findViewById(R.id.add_guest_btn);
        guestList = view.findViewById(R.id.guest_list_view);
        guestName = view.findViewById(R.id.guest_name);
        radioGender = view.findViewById(R.id.radio_gender);
        radioFemale = view.findViewById(R.id.female_radio_btn);
        radioMale=view.findViewById(R.id.male_radio_btn);
        bookNext = view.findViewById(R.id.book_final);

        list = new ArrayList<GuestModel>();
        guestAdapter = new GuestListAdapter(getContext(),R.layout.guest_list_layout);
        guestList.setAdapter(guestAdapter);
        arrayAdapter = new ArrayAdapter<GuestModel>(getContext(), R.layout.guest_list_layout, list);

        bookNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < guestAdapter.getCount(); i++){
                    guestArrayList.add(new GuestModel(guestAdapter.getItem(i).getGuest_name(),guestAdapter.getItem(i).getGender()));
                }

                sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);


                ReservationModel reservation = new ReservationModel(sharedPreferences.getString(checkIn,""),sharedPreferences.getString(checkOut,""), guestArrayList);
                HotelReservationModel hotelReservation = new HotelReservationModel(hotelName,reservation);

                Api.getClient().createReservation(new Gson().toJson(hotelReservation), new Callback<ReservationResponse>(){

                    @Override
                    public void success(ReservationResponse reservationResponse, Response response) {
                        Toast toast = Toast.makeText(getContext(),"Confirmation Number "+reservationResponse.getConfirmation_number() , Toast.LENGTH_LONG);
                        toast.show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println(error.getMessage());

                    }
                });


                guestList.setAdapter(null);

            }
        });

        addGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String guest = guestName.getText().toString();
                String gender="Female";

                int selected=radioGender.getCheckedRadioButtonId();
                radioBtn = view.findViewById(selected);

                if(radioBtn.getText().toString().equals("M"))
                    gender="Male";

                //list.add(new GuestModel(guest,"Female"));
                guestAdapter.add(new GuestModel(guest,gender));
                guestName.setText("");
                //guestList.setAdapter(arrayAdapter);
                guestAdapter.notifyDataSetChanged();;

            }
        });




    }
}
