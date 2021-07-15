package com.example.hotelreservation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.content.Context;

public class HotelSearchFragment extends Fragment {
    ArrayList<GuestModel> list;
    List<GuestModel> guestArrayList = new ArrayList<>();;
    ArrayAdapter<GuestModel> arrayAdapter;
    View view;
    Button searchHotel, bookNext, clear;
    EditText guestName,guestNumber;
    DatePickerDialog.OnDateSetListener dateSetListenerCheckIn, dateSetListenerCheckOut;
    String currentDateString;
    ListView guestList;
    Button addGuest;
    GuestListAdapter guestAdapter;
    RadioGroup radioGender;
    RadioButton radioFemale;
    RadioButton radioMale;
    RadioButton radioBtn;
    TextView hotel,checkInDate,checkOutDate;
    String hotelName;

    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    public static final String name = "nameKey";
    public static final String guestsCount = "guestsCount";

    public static HotelSearchFragment newInstance(String hotel_name) {
        HotelSearchFragment fragment=new HotelSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hotelName",hotel_name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            hotelName=getArguments().getString("hotelName");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_search_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clear = view.findViewById(R.id.clear);
        bookNext = view.findViewById(R.id.book_next);
        checkInDate = view.findViewById(R.id.check_in_date);
        checkOutDate = view.findViewById(R.id.check_out_date);
        //addGuest = view.findViewById(R.id.add_guest_btn);
        //guestList = view.findViewById(R.id.guest_list_view);
        //guestName = view.findViewById(R.id.guest_name);
        //radioGender = view.findViewById(R.id.radio_gender);
        hotel = view.findViewById(R.id.hotel_name_selected);
        guestNumber = view.findViewById(R.id.guest_number);
        guestName = view.findViewById(R.id.name);

        hotel.setText(hotelName);
        //radioFemale = view.findViewById(R.id.female_radio_btn);
        //radioMale=view.findViewById(R.id.male_radio_btn);

        list = new ArrayList<GuestModel>();
        //guestAdapter = new GuestListAdapter(getContext(),R.layout.guest_list_layout);
        //guestList.setAdapter(guestAdapter);
        //arrayAdapter = new ArrayAdapter<GuestModel>(getContext(), R.layout.guest_list_layout,list);

        /*
        bookNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < guestAdapter.getCount(); i++){
                    guestArrayList.add(new GuestModel(guestAdapter.getItem(i).getGuest_name(),guestAdapter.getItem(i).getGender()));
                }


                ReservationModel reservation = new ReservationModel(checkInDate.getText().toString(),checkOutDate.getText().toString(), guestArrayList);
                HotelReservationModel hotelReservation = new HotelReservationModel(hotel.getText().toString(),reservation);

                Api.getClient().createReservation(new Gson().toJson(hotelReservation), new Callback<ReservationResponse>() {
                    @Override
                    public void success(ReservationResponse reservationResponse, Response response) {

                        Toast toast = Toast.makeText(getContext(),"Confirmation Number "+reservationResponse.getConfirmation_number() , Toast.LENGTH_LONG);
                        toast.show();

                        System.out.println(reservationResponse.getConfirmation_number());
                        Log.d("Response",response.toString());

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println(error.getMessage());
                    }

                });

                checkInDate.setText("");
                checkOutDate.setText("");
                guestNumber.setText("");
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


         */
        checkInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calenderInstance = Calendar.getInstance();
                int year=calenderInstance.get(Calendar.YEAR);
                int month=calenderInstance.get(Calendar.MONTH);
                int day=calenderInstance.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), R.style.DialogTheme,dateSetListenerCheckIn,year,month,day);
                dialog.show();

            }
        });

        checkOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calenderInstance = Calendar.getInstance();
                int year=calenderInstance.get(Calendar.YEAR);
                int month=calenderInstance.get(Calendar.MONTH);
                int day=calenderInstance.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), R.style.DialogTheme,dateSetListenerCheckOut,year,month,day);
                dialog.show();
                checkOutDate.setText(currentDateString);
            }
        });

        bookNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelListFragment hotelsListFragment = new HotelListFragment();

                sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(name, guestName.getText().toString());
                editor.putString(guestsCount, guestNumber.getText().toString());
                editor.commit();

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, hotelsListFragment);
                fragmentTransaction.remove(HotelSearchFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInDate.setText("");
                checkOutDate.setText("");
                guestNumber.setText("");
            }
        });

        dateSetListenerCheckIn = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                currentDateString = dayOfMonth + "/" + month + "/" + year;
                checkInDate.setText(currentDateString);
            }
        };

        dateSetListenerCheckOut = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                currentDateString = dayOfMonth + "/" + month + "/" + year;
                checkOutDate.setText(currentDateString);
            }
        };


    }



}
