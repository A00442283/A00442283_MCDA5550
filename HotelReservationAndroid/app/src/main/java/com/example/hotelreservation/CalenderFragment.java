package com.example.hotelreservation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class CalenderFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calenderInstance = Calendar.getInstance();
        int year = calenderInstance.get(Calendar.YEAR);
        int month = calenderInstance.get(Calendar.MONTH);
        int dayOfMonth = calenderInstance.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener)
                getActivity(), year, month, dayOfMonth);
    }
}
