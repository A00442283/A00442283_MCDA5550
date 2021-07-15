package com.example.hotelreservation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfirmedBookingFragment extends Fragment{

    View view;
    String confirmationNumber;
    TextView confirmationDetails;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.confirmed_booking_fragment,container,false);

        if(getArguments() != null){
            confirmationNumber=getArguments().getString("confirmationKey");
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        confirmationDetails = view.findViewById(R.id.confirmation_number);

        confirmationDetails.setText("Booking Successful !! \n"+confirmationNumber);



    }
}
