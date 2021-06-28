package com.example.hotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                switch (item.getItemId()){

                    case R.id.home:
                        fragment=new HomeFragment();
                        break;

                    case R.id.search:
                        fragment=new HotelListFragment();
                        break;

                    case R.id.book:
                        fragment=new HotelSearchFragment();
                        break;

                    case R.id.booked:
                        fragment=null;
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

                return true;
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        
    }
}